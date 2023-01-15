package ems;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
	
	// to add Department
		public Department addDepartment(Department dep) throws IOException, SQLException, ClassNotFoundException {
			EmployeeDaoInterface dao = new EmployeeDaoDB();
			dao.addDepartment(dep);
			System.out.println("Department added successfully!");
			return dep;
		}

		public boolean checkIfDepartmentNameExists(String department) throws ClassNotFoundException, SQLException {
			EmployeeDaoInterface dao = new EmployeeDaoDB();
			Department dep = null;
			try {
				dep = dao.searchByDepartmentname(department);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Some issue occurred");
				e.printStackTrace();
			}
			if (dep == null) {
				return false;
			} else {
				return true;
			}
		}

		public void editDepartment(Department dep) throws IOException, SQLException, ClassNotFoundException {
			EmployeeDaoInterface dao = new EmployeeDaoDB();
			dao.editDepartment(dep);
			System.out.println("Edited Successfully.");
		}

		public List<Department> viewAllDepartment() throws IOException {
			EmployeeDaoInterface dao = new EmployeeDaoDB();
			return dao.viewAllDepartment();
		}
		
		public Department searchByDepId(Integer id) throws IOException {

			EmployeeDaoInterface dao = new EmployeeDaoDB();

			return dao.searchByDepId(id);
		}

		public boolean removeDepartment(String id) throws IOException {
			
			System.out.println("Enter employee id::");
			EmployeeDaoInterface dao = new EmployeeDaoDB();
			dao.removeDepartment(id);

			return false;
		}
}
