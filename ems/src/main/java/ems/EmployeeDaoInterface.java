package ems;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDaoInterface {
	
public void editEmployee(Employee emp) throws IOException;
	
	public List<Employee> viewAll() throws IOException;
	
	public Employee searchById(Integer id) throws IOException;
	
	public Employee searchByUsernameAndPassword(String username, String password) throws IOException;
	
	public Employee addEmployee(Employee emp) throws IOException, SQLException, ClassNotFoundException;
	
	public Employee searchByUsername(String username) throws IOException;
	
	public void removeEmployee(String id) throws IOException;
}