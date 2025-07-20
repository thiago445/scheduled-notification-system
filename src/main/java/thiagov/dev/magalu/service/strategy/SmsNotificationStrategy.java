package thiagov.dev.magalu.service.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import thiagov.dev.magalu.service.NotificationStrategy;
@Component("sms")
public class SmsNotificationStrategy implements NotificationStrategy {

	
	private final Logger logger = LoggerFactory.getLogger(SmsNotificationStrategy.class);

	@Override
	public void sendNotification(String destination, String message) {

		logger.info("enviado notificação [{}] para o sms[{}]", message, destination);
	}

}
