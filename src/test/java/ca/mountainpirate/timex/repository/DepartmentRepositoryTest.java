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

import ca.mountainpirate.timex.model.Department;
import ca.mountainpirate.timex.repository.DepartmentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml" })
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void testFindAllDepartment() {
		List<Department> list = departmentRepository.findAll();
		Assert.assertTrue(!list.isEmpty());
		for (Department department : list) {
			System.out.println(department);
		}
	}
}
