package ca.mountainpirate.timex.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;


public class AsyncWorker implements Worker {
	private static Logger LOG = LoggerFactory.getLogger(AsyncWorker.class);
	
	@Override
	@Async
	public void sendEmail(SimpleMailMessage message) {
		LOG.info("Beung sending email with subject: " + message.getSubject()); 
		
		try {
			LOG.info("working");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		LOG.info("completed sending email with subject " + message.getSubject() + 
				"\n-------------------------");
	}
}
