package ems;

import java.io.IOException;

public class LoginService {
	/**
	 * Log into the system
	 * 
	 * @param username
	 * @param password
	 * @return true if login is successful, else false
	 */
	public Employee login(String username, String password) {
		
		EmployeeDaoInterface dao = new EmployeeDaoDB();
		
		
		Employee emp = null;
		try {
			emp = dao.searchByUsernameAndPassword(username, password);
		}
		catch (IOException e) {
			System.out.println("Some issue occurred");
			e.printStackTrace();
		}
		
		return emp;
	}
	
}

