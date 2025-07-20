package thiagov.dev.magalu.scheduler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import thiagov.dev.magalu.service.NotificationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class MagaluTaskScheduler {
	
	
	private static final Logger logger= LoggerFactory.getLogger(MagaluTaskScheduler.class);
	
	private final NotificationService notificationService;
	
	
	public MagaluTaskScheduler(NotificationService notificationService) {
		this.notificationService = notificationService;
	}


	@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void checkTasks() {
		var dateTime= LocalDateTime.now();
		logger.info("Running at{}", dateTime);
		notificationService.checkAndSend(dateTime);
		
	}

}
