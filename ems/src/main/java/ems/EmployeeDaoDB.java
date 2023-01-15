package ems;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Savepoint;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmployeeDaoDB implements EmployeeDaoInterface {
//
//	private final static String USERNAME = "root";
//
//	private final static String PASSWORD = "root";
//
//	private final static String URL = "jdbc:mysql://localhost:3306/ems";
//
//	@Override
//	public Employee searchByUsernameAndPassword(String username, String password) throws IOException {
//		Connection con = null;
//		Statement statement = null;
//		Employee emp = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//			String query = "select * from employee where username ='" + username + "' and password='" + password + "'";
//
//			System.out.println(query);
//
//			statement = con.createStatement();
//			ResultSet results = statement.executeQuery(query);
//
//			while (results.next()) {
//				emp = new Employee();
//				emp.setId(results.getInt(1));
//				emp.setFirstName(results.getString(2));
//				emp.setLastName(results.getString(3));
//				emp.setGender(Gender.getByValue(results.getString(4)));
//				emp.setUsername(results.getString(5));
//				emp.setPassword(results.getString(6));
//				emp.setEmployeeType(EmployeeType.valueOf(results.getString(7)));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//		return emp;
//	}
//
//	@Override
//	public List<Employee> viewAll() throws IOException {
//		Connection con = null;
//		Statement statement = null;
//		List<Employee> employeeList = new ArrayList<Employee>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//			String query = "SELECT * from employee";
//
//			statement = con.createStatement();
//
//			ResultSet results = statement.executeQuery(query);
//
//			while (results.next()) {
//
//				Employee emp = new Employee();
//				emp.setId(results.getInt(1));
//				emp.setFirstName(results.getString(2));
//				emp.setLastName(results.getString(3));
//				emp.setGender(Gender.getByValue(results.getString(4)));
//				emp.setUsername(results.getString(5));
//				emp.setPassword(results.getString(6));
//				emp.setEmployeeType(EmployeeType.valueOf(results.getString(7)));
//
//				employeeList.add(emp);
//			}
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//		return employeeList;
//
//	}
//
//	@Override
//	public void removeEmployee(String id) throws IOException {
//		Connection con = null;
//		PreparedStatement statement = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//			String query = "DELETE from employee where id=?";
//
//			statement = con.prepareStatement(query);
//
//			statement.setString(1, id);
//
//			System.out.println(statement.toString());
//
//			int rowsAffected = statement.executeUpdate();
//
//			System.out.println("rows==" + rowsAffected);
//			if (rowsAffected > 0) {
//				System.out.println("Successfully Deleted!!");
//			} else {
//				System.out.println("Failed to delete record");
//			}
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//	}
//
//	@Override
//	public void editEmployee(Employee emp) throws IOException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//			String updateQuery = "UPDATE employee set first_name=?, last_name=?, gender=?, password=?, employee_type=? where id=?";
//
//			System.out.println(updateQuery);
//
//			PreparedStatement statement = con.prepareStatement(updateQuery);
//			statement.setString(1, emp.getFirstName());
//			statement.setString(2, emp.getLastName());
//			statement.setString(3, emp.getGender().value);
//			statement.setString(4, emp.getPassword());
//			statement.setString(5, emp.getEmployeeType().value);
//
//			// Set id for where clause
//			statement.setInt(6, emp.getId());
//
//			System.out.println(statement.toString());
//
//			int resultValue = statement.executeUpdate();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public Employee searchById(Integer id) throws IOException {
//		Connection con = null;
//		Statement statement = null;
//		Employee emp = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//			String query = "select * from employee where id =" + id;
//
//			// CallableStatement st = (CallableStatement) con.prepareCall("statement.name");
//			// st.execute();
//
//			statement = con.createStatement();
//			ResultSet results = statement.executeQuery(query);
//
//			while (results.next()) {
//				emp = new Employee();
//				emp.setId(results.getInt(1));
//				emp.setFirstName(results.getString(2));
//				emp.setLastName(results.getString(3));
//				emp.setGender(Gender.getByValue(results.getString(4)));
//				emp.setUsername(results.getString(5));
//				emp.setPassword(results.getString(6));
//				emp.setEmployeeType(EmployeeType.valueOf(results.getString(7)));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//		return emp;
//
//	}
//
//	@Override
//	public Employee addEmployee(Employee emp) throws IOException, SQLException, ClassNotFoundException {
//		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//		String insertQuery = "INSERT INTO employee (first_name, last_name, gender, username, password, employee_type)"
//				+ "value (?, ?, ?, ?, ?, ?)";
//
//		System.out.println(insertQuery);
//
//		PreparedStatement statement = con.prepareStatement(insertQuery);
//		statement.setString(1, emp.getFirstName());
//		statement.setString(5, emp.getPassword());
//		statement.setString(6, emp.getEmployeeType().value);
//		statement.setString(2, emp.getLastName());
//		statement.setString(3, emp.getGender().value);
//		statement.setString(4, emp.getUsername());
//
//		int resultValue = statement.executeUpdate();
//
//
//		if (resultValue == 0) {
//			System.out.println("Failed to insert data. Check your data and try again.");
//		}
//
//		statement.close();
//		con.close();
//
//		return emp;
//
//	}
//
//	@Override
//	public Employee searchByUsername(String username) throws IOException {
//		Connection con = null;
//		Statement statement = null;
//		Employee emp = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//			String query = "select * from employee where username ='" + username + "'";
//
//			System.out.println(query);
//
//			statement = con.createStatement();
//			ResultSet results = statement.executeQuery(query);
//
//			while (results.next()) {
//				emp = new Employee();
//				emp.setId(results.getInt(1));
//				emp.setFirstName(results.getString(2));
//				emp.setLastName(results.getString(3));
//				emp.setGender(Gender.getByValue(results.getString(4)));
//				emp.setUsername(results.getString(5));
//				emp.setPassword(results.getString(6));
//				emp.setEmployeeType(EmployeeType.valueOf(results.getString(7)));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//		return emp;
//	}
//}
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoDB implements EmployeeDaoInterface {
	
	private final static String USERNAME = "root";
	
	private final static String PASSWORD = "root";
	
	private final static String URL = "jdbc:mysql://localhost:3306/ems";
	
	@Override
	public void editEmployee(Employee emp) throws IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			
			String updateQuery = "UPDATE employee set first_name=?, last_name=?, gender=?, password=?, employee_type=? where emp_id=?";		
			System.out.println(updateQuery);
			
			
			PreparedStatement statement = con.prepareStatement(updateQuery);
			statement.setString(1, emp.getFirstName());
			statement.setString(2, emp.getLastName());
			statement.setString(3, emp.getGender().value);
			statement.setString(4, emp.getPassword());
			statement.setString(5, emp.getEmployeeType().value);
			
			//Set id for where clause
			statement.setInt(6, emp.getId());
			
			
			System.out.println(statement.toString());
			
			int resultValue = statement.executeUpdate();

			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public List<Employee> viewAll() throws IOException {
		Connection con = null;
		Statement statement = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "SELECT * from employee";
			
			statement = con.createStatement();
			
			ResultSet results = statement.executeQuery(query);
			
			
			while (results.next()) {
				
				Employee emp = new Employee();
				emp.setId(results.getInt(1));
				emp.setFirstName(results.getString(2));
				emp.setLastName(results.getString(3));
				emp.setGender(Gender.getByValue(results.getString(4)));
				emp.setUsername(results.getString(5));
				emp.setPassword(results.getString(6));
				emp.setEmployeeType(EmployeeType.valueOf(results.getString(7)));
				
				employeeList.add(emp);
			}
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return employeeList;
		
	}
	
	@Override
	public Employee searchById(Integer id) throws IOException {
		Connection con = null;
		Statement statement = null;
		Employee emp = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "select * from employee where emp_id =" + id;
			
			//			CallableStatement st = (CallableStatement) con.prepareCall("statement.name");
			//			st.execute();
			
			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			while (results.next()) {
				emp = new Employee();
				emp.setId(results.getInt(1));
				emp.setFirstName(results.getString(2));
				emp.setLastName(results.getString(3));
				emp.setGender(Gender.getByValue(results.getString(4)));
				emp.setUsername(results.getString(5));
				emp.setPassword(results.getString(6));
				emp.setEmployeeType(EmployeeType.valueOf(results.getString(7)));
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return emp;
		
	}
	
	@Override
	public Employee searchByUsernameAndPassword(String username, String password) throws IOException {
		System.out.println("Inside search by username and password method.. EmployeeDaoDb. DB store \n\n");
		Connection con = null;
		Statement statement = null;
		Employee emp = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "select * from employee where username ='" + username + "' and password='" + password + "'";
			
			System.out.println(query);
			
			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			while (results.next()) {
				emp = new Employee();
				emp.setId(results.getInt(1));
				emp.setFirstName(results.getString(2));
				emp.setLastName(results.getString(3));
				emp.setGender(Gender.getByValue(results.getString(4)));
				emp.setUsername(results.getString(5));
				emp.setPassword(results.getString(6));
				emp.setEmployeeType(EmployeeType.valueOf(results.getString(7)));
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return emp;
	}
	
	@Override
	public Employee addEmployee(Employee emp) throws IOException, SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		String insertQuery = "INSERT INTO employee (first_name, last_name, gender, username, password, employee_type)"
		        + "value (?, ?, ?, ?, ?, ?)";
		
		System.out.println(insertQuery);
		
		//		Statement statement = con.createStatement();
		
		PreparedStatement statement = con.prepareStatement(insertQuery);
		statement.setString(1, emp.getFirstName());
		statement.setString(5, emp.getPassword());
		statement.setString(6, emp.getEmployeeType().value);
		statement.setString(2, emp.getLastName());
		statement.setString(3, emp.getGender().value);
		statement.setString(4, emp.getUsername());
		
		int resultValue = statement.executeUpdate();
		
		
		if (resultValue == 0) {
			System.out.println("Failed to insert data. Check your data and try again.");
		}
		
		statement.close();
		con.close();
		
		return emp;
		
	}
	
	@Override
	public Employee searchByUsername(String username) throws IOException {
		Connection con = null;
		Statement statement = null;
		Employee emp = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "select * from employee where username ='" + username + "'";
			
			System.out.println(query);
			
			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			while (results.next()) {
				emp = new Employee();
				emp.setId(results.getInt(1));
				emp.setFirstName(results.getString(2));
				emp.setLastName(results.getString(3));
				emp.setGender(Gender.getByValue(results.getString(4)));
				emp.setUsername(results.getString(5));
				emp.setPassword(results.getString(6));
				emp.setEmployeeType(EmployeeType.valueOf(results.getString(7)));
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return emp;
	}
	
	@Override
	public void removeEmployee(String id) throws IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		//		Statement statement = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "DELETE from employee where emp_id=?";
			
			statement = con.prepareStatement(query);
			
			statement.setString(1, id);
			
			System.out.println(statement.toString());
			
			int rowsAffected = statement.executeUpdate();
			
			System.out.println("rows==" + rowsAffected);
			if (rowsAffected > 0) {
				System.out.println("Successfully Deleted!!");
			} else {
				System.out.println("Failed to delete record");
			}
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
