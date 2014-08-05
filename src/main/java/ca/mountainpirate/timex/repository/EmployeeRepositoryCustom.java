package ca.mountainpirate.timex.repository;

import java.util.List;

import ca.mountainpirate.timex.model.Employee;

public interface EmployeeRepositoryCustom {
	List<Employee> employeesWithUnsubmittedTimesheets();
}
