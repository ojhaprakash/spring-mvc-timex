package ca.mountainpirate.timex.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mountainpirate.timex.model.Department;
import ca.mountainpirate.timex.model.Employee;
import ca.mountainpirate.timex.model.Timesheet;
import ca.mountainpirate.timex.repository.DepartmentRepository;
import ca.mountainpirate.timex.repository.EmployeeRepository;
import ca.mountainpirate.timex.repository.TimesheetRepository;

@Service("timesheetService")
@Transactional(readOnly=true)
public class TimesheetServiceImpl implements TimesheetService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TimesheetRepository timesheetRepository;
	
	@Autowired
	private AsyncMailService asyncMailService;

	@Override
	public void deleteTimeSheet(Integer timesheetId) {
		timesheetRepository.delete(timesheetId);

	}

	@Override
	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Timesheet getTimesheet(Integer timesheetId) {
		return timesheetRepository.findOne(timesheetId);
	}

	@Override
	public Timesheet getTimeSheet(Integer employeeId, Date periodEndingDate) {
		return timesheetRepository.findByEmployeeIdAndPeriodEndingDate(employeeId, periodEndingDate);
	}

	@Override
	public List<Timesheet> getTimesheets() {
		return timesheetRepository.findAll();
	}

	@Override
	public List<Timesheet> getTimesheets(Integer employeeId) {
		return timesheetRepository.findByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly=false)
	public Timesheet saveTimesheet(Timesheet timesheet) {
		return  timesheetRepository.save(timesheet);
	}

	@Override
	public Employee getEmployee(String email) {
		List<Employee> list = employeeRepository.findByEmail(email);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	@Transactional(readOnly=false)
	public Timesheet submitTimesheet(Integer timesheetId) {
		Timesheet timesheet = timesheetRepository.findOne(timesheetId);
		if (timesheet !=null) {
			timesheet.setStatusCode(Timesheet.StatusCode.P);
			timesheet = timesheetRepository.save(timesheet);
			SimpleMailMessage message = new SimpleMailMessage();
			message.setText(timesheet.toString());
			message.setTo("ojhaprakash@gmail.com");
			asyncMailService.doEmail(message);
		}
		return timesheet;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
}
