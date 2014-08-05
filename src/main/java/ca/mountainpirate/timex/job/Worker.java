package ca.mountainpirate.timex.job;

import org.springframework.mail.SimpleMailMessage;

public interface Worker {

	void sendEmail(SimpleMailMessage message);
}
