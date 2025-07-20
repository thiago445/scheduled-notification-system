package thiagov.dev.magalu.service.strategy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import thiagov.dev.magalu.service.NotificationStrategy;

@Component("email")
public class EmailNotificationStrategy implements NotificationStrategy {
	
	private final Logger logger = LoggerFactory.getLogger(EmailNotificationStrategy.class);
	@Override
	public void sendNotification(String destination, String message) {
		// TODO Auto-generated method stub
		logger.info("enviado notificação [{}] para o email[{}]", message, destination);
		
	}
	

}
