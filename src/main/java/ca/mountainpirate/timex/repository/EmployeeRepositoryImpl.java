package ca.mountainpirate.timex.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import ca.mountainpirate.timex.model.Employee;
import ca.mountainpirate.timex.model.Timesheet;


public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Employee> employeesWithUnsubmittedTimesheets() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> employee = cq.from(Employee.class);
		Join<Employee, Timesheet> timesheet = employee.join("timesheets");
		cq.select(employee).distinct(true).where(cb.equal(timesheet.get("statusCode"), Timesheet.StatusCode.U));
		
		TypedQuery<Employee> typedQuery = entityManager.createQuery(cq);
		return typedQuery.getResultList();
		
	}
}
