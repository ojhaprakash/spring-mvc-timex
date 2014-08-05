package ca.mountainpirate.timex.service;

import org.springframework.mail.SimpleMailMessage;

public interface AsyncMailService {
	
	void doEmail(SimpleMailMessage message);
}
