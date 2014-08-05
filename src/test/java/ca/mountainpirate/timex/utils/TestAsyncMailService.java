package ca.mountainpirate.timex.utils;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import ca.mountainpirate.timex.service.AsyncMailService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:root-context.xml"})
@TestExecutionListeners(listeners={DependencyInjectionTestExecutionListener.class})
public class TestAsyncMailService {

	@Autowired
	private AsyncMailService asyncMailService;

	@Test
	@Ignore
	public void testSend() throws InterruptedException {	
		
		//for (int i=0; i<10; i++) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo("ojhaprakash@gmail.com");
			message.setSubject("testing mail send " );
			message.setText("Sending email through gmail");
			asyncMailService.doEmail(message);
		//}
		Thread.sleep(30000L);
		
	}
}
