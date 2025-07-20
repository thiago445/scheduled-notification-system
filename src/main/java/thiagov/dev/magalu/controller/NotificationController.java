package thiagov.dev.magalu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import thiagov.dev.magalu.dto.scheduleNotificationDto;
import thiagov.dev.magalu.entity.Notification;
import thiagov.dev.magalu.repository.NotificationRepository;
import thiagov.dev.magalu.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	
	private final NotificationService notificationService;
	
	
	
	
	public NotificationController(NotificationService notificationService) {
		super();
		this.notificationService = notificationService;
	}




	@PostMapping()
	public ResponseEntity<?> scheduleNotification(@RequestBody scheduleNotificationDto dto){
		
		notificationService.scheduleNotification(dto);
		
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/{notificationId}")
	public ResponseEntity<Notification> getNotification(@PathVariable("notificationId") Long notificationId){
		var notification = notificationService.findById(notificationId);
		
		if(notification.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(notification.get());
	}
	
	@DeleteMapping("/{notificationId}")
	public ResponseEntity<Void> cancelNotification(@PathVariable("notificationId") Long notificationId){
		notificationService.CancelNotification(notificationId);
		return ResponseEntity.noContent().build();
	}
}
