package ca.mountainpirate.timex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.mountainpirate.timex.model.Employee;

import java.lang.String;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {

	List<Employee> findByEmail(String email);
}
