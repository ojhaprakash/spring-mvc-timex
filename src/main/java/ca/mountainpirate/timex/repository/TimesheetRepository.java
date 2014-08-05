package ca.mountainpirate.timex.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.mountainpirate.timex.model.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

	List<Timesheet> findByEmployeeId(Integer employeeId);
	
	Timesheet findByEmployeeIdAndPeriodEndingDate(Integer employeeId, Date periodEndingDate);
}
