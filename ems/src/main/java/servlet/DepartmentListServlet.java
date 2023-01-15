package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import ems.Department;
import ems.DepartmentService;
import ems.Employee;
import ems.EmployeeService;

/**
 * Servlet implementation class DepartmentListServlet
 */
@WebServlet("/department")
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside get Method.. Department Servlet");
		// TODO Auto-generated method stub
		DepartmentService dep = new DepartmentService();
		List<Department> departments = dep.viewAllDepartment();
	
		
		request.setAttribute("departments", departments);
		System.out.println(departments);
		
		request.getRequestDispatcher("departmentlist.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("Inside do doPost method...");
		
		String method = request.getParameter("method");
		
		//Forwarding call to delete method based on the method passed as parameter. Workaround
		if (method != null && "delete".equals(method)) {
			doDelete(request, response);
		} else {
			doGet(request, response);
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside do delete method...");
		String id = request.getParameter("id");
		DepartmentService empService = new DepartmentService();
		empService.removeDepartment(id);
		
		//Passing message to front end through send redirect.
		//Set parameter in URL and use request.getParameter in jsp
		String successMessage = "?message=Deleted Successfully!!!";
		
		response.sendRedirect("/ems/department"+successMessage);	
	}

}