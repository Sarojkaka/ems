package ems;

import java.util.Objects;

public class Department {
	
	private Integer depId;
	
	private String department;
	
	private String details;
	
	public Department() {
		super();
	}

	public Department(Integer depId, String department, String details) {
		super();
		this.depId = depId;
		this.department = department;
		this.details = details;
	}

	public Department(String department, String details) {
		super();
		this.department = department;
		this.details = details;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", department=" + department + ", details=" + details + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(depId, department, details);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(depId, other.depId) && Objects.equals(department, other.department)
				&& Objects.equals(details, other.details);
	}
}
