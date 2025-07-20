package thiagov.dev.magalu.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thiagov.dev.magalu.dto.scheduleNotificationDto;
import thiagov.dev.magalu.entity.Notification;
import thiagov.dev.magalu.entity.Status;
import thiagov.dev.magalu.repository.NotificationRepository;
import thiagov.dev.magalu.service.strategy.EmailNotificationStrategy;

@Service
public class NotificationService {
	private final NotificationRepository notificationRepository;
	private final Logger logger = LoggerFactory.getLogger(NotificationService.class);
	@Autowired
	private Map<String, NotificationStrategy> strategyMap;

	public NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}
	
	
	public void scheduleNotification(scheduleNotificationDto dto) {
		notificationRepository.save(dto.toNotification());
		
	}
	
	public Optional<Notification> findById(Long notificationId){
		return notificationRepository.findById(notificationId);
	}
	
	
	public void CancelNotification(Long notificationId){
		var notification = findById(notificationId);
		
		if(notification.isPresent()) {
			notification.get().setStatus(Status.Values.CANCELED.toStatus());
			notificationRepository.save(notification.get());
		}
			
		return;
	}
	
	public void checkAndSend(LocalDateTime dateTime){
		var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
				List.of(Status.Values.PENDING.toStatus(),Status.Values.ERROR.toStatus()),
				dateTime
		);
		
		notifications.forEach(sendNotification());
	}


	private Consumer<Notification> sendNotification() {
		return n -> {
			strategyMap.get(n.getChannel().getDescription())
			.sendNotification(n.getDestination(), n.getMessage());
			logger.info("Canal: {}", n.getChannel().getDescription());

			
			
			
			n.setStatus(Status.Values.SUCCESS.toStatus());
			notificationRepository.save(n);
			
		};
	}
	
	
}
