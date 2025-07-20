package thiagov.dev.magalu.dto;

import java.time.LocalDateTime;
import thiagov.dev.magalu.entity.Channel;
import thiagov.dev.magalu.entity.Notification;
import thiagov.dev.magalu.entity.Status;
public record scheduleNotificationDto(LocalDateTime dateTime,
									String destination,
									String message,
									Channel.Values channel) {
	
	public Notification toNotification() {
		return new Notification(
			dateTime,
			destination,
			message,
			channel.toChannel(),
			Status.Values.PENDING.toStatus());
	}

}
