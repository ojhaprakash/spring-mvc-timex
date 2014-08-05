package ca.mountainpirate.timex.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ca.mountainpirate.timex.component.AuthenticationFacade;
import ca.mountainpirate.timex.model.Department;
import ca.mountainpirate.timex.model.Employee;
import ca.mountainpirate.timex.model.Timesheet;
import ca.mountainpirate.timex.service.TimesheetService;

@Controller
@RequestMapping("/timesheets")
@SessionAttributes({"departments"})
public class TimesheetController {
	@Autowired
	private TimesheetService timesheetService;

	@Autowired
	private AuthenticationFacade authenticationFacade;

	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@ModelAttribute("departments")
	public List<Department> getDepartments() {
		return timesheetService.getDepartments();
	}

	@RequestMapping(value = "/{timesheetId}", method = RequestMethod.GET)
	public String getTimesheet(@PathVariable Integer timesheetId, Model model) {
		Timesheet timesheet = null;
		if (timesheetId != null) {
			timesheet = timesheetService.getTimesheet(timesheetId);
		}
		if (timesheet != null) {
			model.addAttribute(timesheet);
		} else {
			timesheet = new Timesheet();
			Employee employee = getCurrentEmployee();

			if (employee != null) {
				timesheet.setEmployee(employee);
			}
			model.addAttribute(timesheet);
		}
		return "timesheet";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getTimesheet(Model model) {
		return getTimesheet(null, model);
	}

	@RequestMapping(value = "/printreport/{timesheetId}")
	public String getPrintReport(@PathVariable Integer timesheetId, Model model) {
		Timesheet timesheet = this.timesheetService.getTimesheet(timesheetId);
		model.addAttribute(timesheet);
		return "printreport";
	}

	@RequestMapping(value = "/myreport")
	public String getMyReport(Model model) {
		Employee employee = getCurrentEmployee();
		List<Timesheet> timesheets = getTimesheetsForEmployee(employee);
		if (timesheets !=null) {
			model.addAttribute("timesheets", timesheets);
		}
		return "myreport";
	}
	
	@RequestMapping(value = "/managerreport")
	public String getManagerReport(Model model) {
		List<Employee> employees = timesheetService.getEmployees();
		System.out.println("managerreport total empoyees " + (employees == null ? " null " : employees.size()) );
		if (employees !=null) {
			model.addAttribute("employees", employees);
		}
		
		return "managerreport";
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public String getTimesheets(Model model) {
		Employee employee = getCurrentEmployee();
		List<Timesheet> timesheets = getTimesheetsForEmployee(employee);
		if (timesheets != null) {
			model.addAttribute("timesheets", timesheets);
		}
		return "timesheets";
	}

	private String getCurrentUsername() {
		return authenticationFacade.getAuthentication().getName();
	}
	
	private Employee getCurrentEmployee() {
		String username = getCurrentUsername();
		Employee loggedInEmployee = null;

		if (username != null) {
			loggedInEmployee = timesheetService.getEmployee(username);
		}
		return loggedInEmployee;
	}

	private List<Timesheet> getTimesheetsForEmployee(Employee employee) {
		List<Timesheet> timesheets = null;
		if (employee != null) {
			System.out
					.println("timesheets for employeeId: " + employee.getId());
			timesheets = timesheetService.getTimesheets(employee.getId());
		}
		return timesheets;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@ModelAttribute("timesheet") Timesheet timesheet,
			BindingResult bindingResult) {
		Employee employee = timesheet.getEmployee();
		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("employee is null");
		}
		if (bindingResult.hasErrors()) {
			System.out.println("bindingresult has errors "
					+ bindingResult.getErrorCount());
			return "timesheet";
		}
		timesheetService.saveTimesheet(timesheet);
		return "redirect:/timesheets";
	}

	@RequestMapping(value = "/submit/{timesheetId}", method = RequestMethod.GET)
	public String submitTimesheet(@PathVariable Integer timesheetId) {
		timesheetService.submitTimesheet(timesheetId);
		return "redirect:/timesheets";
	}
}
