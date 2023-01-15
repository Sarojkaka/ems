package ems;

public enum EmployeeType {
	
	ADMIN("ADMIN"),
	USER("USER");
	
	String value;
	
	EmployeeType(String value) {
		this.value = value;
	}
	
	public static EmployeeType getByValue(String employeeType) {
		for (EmployeeType g : EmployeeType.values()) {
			if (g.value.equals(employeeType)) {
				return g;
			}
		}
		return null;
	}
}