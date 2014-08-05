package ca.mountainpirate.timex.model;

import org.junit.Test;

import ca.mountainpirate.timex.model.Employee;
import ca.mountainpirate.timex.model.Employee.EmployeeCode;

public class EmployeeTest {

	
	@Test
	public void testEmployeeCode() {
		Employee.EmployeeCode employeeCode = Employee.EmployeeCode.H;
		System.out.println("employeeCode: " + employeeCode + " getRole: " + employeeCode.getRole());
		employeeCode = EmployeeCode.valueOf("H");
		System.out.println("obtained using valueOf: " + employeeCode + " getRole: " + employeeCode.getRole());
	}
}
