package ca.mountainpirate.timex.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the timesheet database table.
 * 
 */
@Entity
public class Timesheet implements Serializable {
	
	public enum StatusCode {
		P("PENDING"), A("APPROVED"), U("UNSUBMITTED");
		
		private String status;
		private StatusCode(String status) {
			this.status = status;
		}
		
		public String getStatus() {
			return this.status;
		}
	};
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private int minutesFri;

	private int minutesMon;

	private int minutesSat;

	private int minutesSun;

	private int minutesThu;

	private int minutesTue;

	private int minutesWed;
	
	@Transient
	private Integer total;

	@Temporal(TemporalType.DATE)
	private Date periodEndingDate;

	@Enumerated(EnumType.STRING)
	private StatusCode statusCode = StatusCode.U;

	//bi-directional many-to-one association to Employee
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="employeeId")
	private Employee employee;

	private String departmentCode;


	public Timesheet() {
	}


	public String getDepartmentCode() {
		return departmentCode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Integer getId() {
		return id;
	}

	public int getMinutesFri() {
		return minutesFri;
	}

	public int getMinutesMon() {
		return minutesMon;
	}

	public int getMinutesSat() {
		return minutesSat;
	}

	public int getMinutesSun() {
		return minutesSun;
	}

	public int getMinutesThu() {
		return minutesThu;
	}

	public int getMinutesTue() {
		return minutesTue;
	}

	public int getMinutesWed() {
		return minutesWed;
	}

	public Date getPeriodEndingDate() {
		return periodEndingDate;
	}


	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMinutesFri(int minutesFri) {
		this.minutesFri = minutesFri;
	}

	public void setMinutesMon(int minutesMon) {
		this.minutesMon = minutesMon;
	}

	public void setMinutesSat(int minutesSat) {
		this.minutesSat = minutesSat;
	}

	public void setMinutesSun(int minutesSun) {
		this.minutesSun = minutesSun;
	}

	public void setMinutesThu(int minutesThu) {
		this.minutesThu = minutesThu;
	}

	public void setMinutesTue(int minutesTue) {
		this.minutesTue = minutesTue;
	}

	public void setMinutesWed(int minutesWed) {
		this.minutesWed = minutesWed;
	}

	public void setPeriodEndingDate(Date periodEndingDate) {
		this.periodEndingDate = periodEndingDate;
	}



	@Override
	public String toString() {
		return "Timesheet [id=" + id + ",departmentCode=" + getDepartmentCode()
				+ ", minutesFri=" + minutesFri
				+ ", minutesMon=" + minutesMon + ", minutesSat=" + minutesSat
				+ ", minutesSun=" + minutesSun + ", minutesThu=" + minutesThu
				+ ", minutesTue=" + minutesTue + ", minutesWed=" + minutesWed
				+ ", periodEndingDate=" + periodEndingDate + ", statusCode="
				+ getStatusCode() + "]";
	}


	public Integer getTotal() {
		if (total == null) {
			total = (minutesMon + minutesTue + minutesWed + minutesThu + minutesFri + minutesSat + minutesMon);
		}
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public StatusCode getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}


}