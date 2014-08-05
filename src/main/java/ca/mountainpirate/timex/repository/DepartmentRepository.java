package ca.mountainpirate.timex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.mountainpirate.timex.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
	
}
