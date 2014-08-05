package ca.mountainpirate.timex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncMailServiceImpl implements AsyncMailService {
	private static Logger LOG = LoggerFactory
			.getLogger(AsyncMailServiceImpl.class);

	@Autowired
	private MailSender mailSender;

	@Override
	@Async
	public void doEmail(SimpleMailMessage message) {
		LOG.info(String.format("Sending email to:%s, with subject: %s, "
				+ " and text: %s%n", message.getTo(), message.getSubject(), message.getText()));
		//uncomment to send actual email
		//mailSender.send(message);
		
		//Thread.sleep is only to simulate a long process 
		//comment out if sending actual email		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { return ; }

		LOG.info("completed sending email with subject " + message.getSubject()
				+ "\n-------------------------");
	}
}
