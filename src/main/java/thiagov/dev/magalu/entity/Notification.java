package thiagov.dev.magalu.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_notifications")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long notificationId;
	
	private LocalDateTime dateTime;
	
	private String destination;
	
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "channel_id")
	private Channel channel;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;
	
	

	public Notification() {
		
	}
	

	public Notification(LocalDateTime dateTime, String destination, String message, Channel channel, Status status) {
		super();
		this.dateTime = dateTime;
		this.destination = destination;
		this.message = message;
		this.channel = channel;
		this.status = status;
	}


	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
	

}
