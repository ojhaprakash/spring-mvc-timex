package ca.mountainpirate.timex.repository;

import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ca.mountainpirate.timex.model.Timesheet;
import ca.mountainpirate.timex.repository.TimesheetRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml" })
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class TimesheetRepositoryTest {

	@Autowired
	private TimesheetRepository timesheetRepository;

	@Test
	public void testFindAllTimesheets() {
		List<Timesheet> list = timesheetRepository.findAll();
	
		Assert.assertTrue(!list.isEmpty());
		for (Timesheet timesheet : list) {
			System.out.println(timesheet);
		}
	}
	
	@Test
	public void testFindByEmployeeId() {
		Integer employeeId = 2;
		List<Timesheet> list = timesheetRepository.findByEmployeeId(employeeId);
		Assert.assertTrue(!list.isEmpty());
		for (Timesheet timesheet : list) {
			System.out.println(timesheet);
		}
	}
	
	@Test
	public void testFindByEmployeeIdAndPeriodEndingDate() {
		Integer employeeId = 2;
		java.sql.Date date = Date.valueOf("2006-08-19");
		
		Timesheet timesheet = timesheetRepository.findByEmployeeIdAndPeriodEndingDate(employeeId, date);
		System.out.println("testFindByEmployeeIdAndPeriodEndingDate: " +timesheet);
	}
}
