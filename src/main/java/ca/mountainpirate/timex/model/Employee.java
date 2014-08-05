package ca.mountainpirate.timex.model;

import java.io.Serializable;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
public class Employee implements Serializable {
	
	public enum EmployeeCode {
		H("ROLE_USER"),
		M("ROLE_MANAGER"),
		E("ROLE_EXECUTIVE");
		private String role;
		
		private EmployeeCode(String role) {
			this.role = role;
		}
		
		public String getRole() {
			return this.role;
		}
	};
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", employeeCode="
				+ getEmployeeCode() + ", userRole=" + getUserRole() + ", managerId=" + managerId + ", name=" + name
				+ ", password=" + password + "]";
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(unique=true)
	private String email;

	@Enumerated(EnumType.STRING)
	private EmployeeCode employeeCode;

	private Integer managerId;

	private String name;

	private String password;
	


	//bi-directional many-to-one association to Timesheet
	@OneToMany(mappedBy="employee")
	private List<Timesheet> timesheets;

	public Employee() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getManagerId() {
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Timesheet> getTimesheets() {
		return this.timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public String getUserRole() {
		return employeeCode.getRole();
	}

	public EmployeeCode getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(EmployeeCode employeeCode) {
		this.employeeCode = employeeCode;
	}
}