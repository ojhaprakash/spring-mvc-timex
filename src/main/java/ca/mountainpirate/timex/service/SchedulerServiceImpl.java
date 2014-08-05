package ca.mountainpirate.timex.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ca.mountainpirate.timex.model.Employee;
import ca.mountainpirate.timex.repository.EmployeeRepository;

@Service
public class SchedulerServiceImpl implements SchedulerService {
	protected static Logger LOG = LoggerFactory.getLogger(SchedulerService.class);
	
	@Autowired
	private AsyncMailService asyncMailService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	//@Scheduled(fixedDelay=5000)
	@Scheduled(cron="0 45 18 * * 5") 
	public void emailUnsubmittedEmployees() {
		List<Employee> employees = employeeRepository.employeesWithUnsubmittedTimesheets();
		LOG.info("start scheduled emailUnsubmittedEmployees");
		for (Employee employee : employees) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(employee.getEmail());
			message.setFrom("accounting@mountainpirate.com");
			message.setSubject("Submit your Timesheet");
			message.setText("You have unsubmitted timesheet, please submit it to get paid");
			asyncMailService.doEmail(message);
		}
		LOG.info("end scheduled emailUnsubmittedEmployees");

	}

}
