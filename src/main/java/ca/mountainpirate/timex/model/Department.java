package ca.mountainpirate.timex.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String departmentCode;

	private String name;

	public Department() {
	}


	public String getDepartmentCode() {
		return departmentCode;
	}

	public String getName() {
		return name;
	}


	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Department [departmentCode=" + departmentCode + ", name="
				+ name + "]";
	}

}