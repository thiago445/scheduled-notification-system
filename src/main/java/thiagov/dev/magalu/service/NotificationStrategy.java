package thiagov.dev.magalu.service;



public interface NotificationStrategy {
	
	void sendNotification(String destination, String message);

}
