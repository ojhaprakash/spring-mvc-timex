package ca.mountainpirate.timex.service;

import java.sql.Date;
import java.util.List;

import ca.mountainpirate.timex.model.Department;
import ca.mountainpirate.timex.model.Employee;
import ca.mountainpirate.timex.model.Timesheet;

public interface TimesheetService {
	void deleteTimeSheet(Integer timesheetId);

	List<Department> getDepartments();

	Timesheet getTimesheet(Integer timesheetId);

	Timesheet getTimeSheet(Integer employeeId, Date periodEndingDate);

	List<Timesheet> getTimesheets();

	List<Timesheet> getTimesheets(Integer employeeId);

	Timesheet saveTimesheet(Timesheet timesheet);
	
	Employee getEmployee(String email);
	
	List<Employee> getEmployees();
	
	Timesheet submitTimesheet(Integer timesheetId);
}
