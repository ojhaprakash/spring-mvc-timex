package ca.mountainpirate.timex.repository;

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

import ca.mountainpirate.timex.model.Employee;
import ca.mountainpirate.timex.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml" })
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void testFindAllEmployees() {
		List<Employee> list = employeeRepository.findAll();
		Assert.assertTrue(!list.isEmpty());
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void employeesWithUnsubmittedTimesheetsTest() {
		List<Employee> list = employeeRepository.employeesWithUnsubmittedTimesheets();
		System.out.println("unsubmitted ones");
		for (Employee e : list) {
			System.out.println(e);
		}
	}
}
