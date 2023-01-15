package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import ems.Department;
import ems.DepartmentService;
import ems.Employee;
import ems.EmployeeService;
import ems.EmployeeType;
import ems.Gender;

/**
 * Servlet implementation class DepartmentRegistrationServlet
 */
@WebServlet("/depregister")
public class DepartmentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		
		String id = request.getParameter("id");
		System.out.println("ID::"+id);
		
		int depId= 0;
		if (id != null && id != "") {
			depId = Integer.parseInt(id);
		}
		
		if (depId == 0) {
			response.sendRedirect("departmentreg.jsp");
		} else {
			// Get employee value
			
			DepartmentService departmentService = new DepartmentService();
			Department dep = departmentService.searchByDepId(depId);
			
			request.setAttribute("id", dep.getDepId());
			request.setAttribute("Department", dep.getDepartment());
			request.setAttribute("lastName", dep.getDetails());
			request.setAttribute("department", dep);
			request.getRequestDispatcher("/departmentreg.jsp").forward(request, response);
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside post method");
		String department = request.getParameter("department");
		String details = request.getParameter("details");
		
		Department dep = new Department(department, details);
		
		DepartmentService dpService = new DepartmentService();
		

		
		try {
			if (dpService.checkIfDepartmentNameExists(department)) {
				System.out.println("This department has been taken.");
				
				request.setAttribute("error", "This Department has been taken. Pick another Department name.");
				
				request.setAttribute("department", department);
				request.setAttribute("details", details);

				RequestDispatcher rd = request.getRequestDispatcher("departmentreg.jsp");
				rd.forward(request, response);
				
				return;
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			String id = request.getParameter("id");
			System.out.println("ID::"+id);
			
			int depId= 0;
			if (id != null && id != "") {
				depId = Integer.parseInt(id);
			}
			dep.setDepId(depId);
			
			
			if (depId == 0) {
				dpService.addDepartment(dep);
			} else {
				dpService.editDepartment(dep);
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			request.setAttribute("internalError", "Internal Server error. Please contact your admin!!!");
			e.getStackTrace();
			
			request.setAttribute("department", department);
			request.setAttribute("details", details);

			
			request.setAttribute("department", dep);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			
			return;
		}
		
		request.setAttribute("message", "Department Registered Successfully!!!");
		
		request.getRequestDispatcher("/department").forward(request, response);
		
		
		
	}

}