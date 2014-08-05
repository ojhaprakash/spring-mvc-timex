package ca.mountainpirate.timex.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import ca.mountainpirate.timex.controller.TimesheetController;
import ca.mountainpirate.timex.model.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml",
"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class TimesheetControllerTest {

	@Autowired
	TimesheetController timesheetController;

	@Test
	public void test() {
		List<Department> departments = timesheetController.getDepartments();
		Assert.assertTrue(!departments.isEmpty());
		for (Department department : departments) {
			System.out.println(department);
		}
	}
}
