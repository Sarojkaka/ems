package ems;

import java.util.Objects;

public class Employee {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private Gender gender;
	
	private String username;
	
	private String password;
	
	private EmployeeType employeeType;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String firstName, String lastName, Gender gender, String username, String password,
	    EmployeeType employeeType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.employeeType = employeeType;
	}
	
	public Employee(String firstName, String lastName, Gender gender, String username, String password,
	    EmployeeType employeeType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.employeeType = employeeType;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public EmployeeType getEmployeeType() {
		return employeeType;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", username="
		        + username + ", password=" + password + ", employeeType=" + employeeType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(employeeType, firstName, gender, id, lastName, password, username);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeType == other.employeeType && Objects.equals(firstName, other.firstName) && gender == other.gender
		        && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
		        && Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
}