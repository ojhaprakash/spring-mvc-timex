package ca.mountainpirate.timex.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import ca.mountainpirate.timex.model.Timesheet;
import ca.mountainpirate.timex.service.TimesheetService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:root-context.xml"})
@TestExecutionListeners(listeners={DependencyInjectionTestExecutionListener.class})
public class TimesheetServiceTest {

	@Autowired
	private TimesheetService timesheetService;

	@Test
	@Ignore
	public void testGetTimesheets() {
		System.out.println("testGetTimesheets");
		List<Timesheet> list = timesheetService.getTimesheets();
		Assert.assertTrue(!list.isEmpty());

		for (Timesheet timesheet : list) {
			System.out.println(timesheet);
		}
	}

	@Test
	public void testGetTimesheetsByEmployeeId() {
		System.out.println("testGetTimesheetsByEmployeeId");
		Integer employeeId = 2;

		List<Timesheet> timesheets = timesheetService.getTimesheets(employeeId);
		for (Timesheet timesheet : timesheets) {
			System.out.println(timesheet);
		}
	}
}
