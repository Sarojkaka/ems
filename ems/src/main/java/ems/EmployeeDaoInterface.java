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

	public Department addDepartment(Department dep)throws IOException, SQLException, ClassNotFoundException;

	public Department searchByDepartmentname(String department)throws IOException, SQLException, ClassNotFoundException;

	public void editDepartment(Department dep)throws IOException, SQLException, ClassNotFoundException;

	public List<Department> viewAllDepartment()throws IOException;

	public Department searchByDepId(Integer id)throws IOException;

	public void removeDepartment(String id)throws IOException;
	
	

}