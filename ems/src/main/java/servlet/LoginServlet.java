package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;

import ems.Employee;
import ems.EmployeeType;
import ems.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String name = request.getParameter("name");
		System.out.println("Inside do get method on login servlet");

		if (name != null) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login/login.jsp");
		}

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username:::" + username);
		System.out.println("password::"+ password);
		
		LoginService loginService = new LoginService();
		Employee emp = loginService.login(username, password);
		
		if (emp != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", emp);
			session.setAttribute("lastActive", LocalDateTime.now());
		}
		
		if  (emp != null && emp.getEmployeeType() == EmployeeType.ADMIN) {
			
			response.sendRedirect("admindash.jsp");
		} else if (emp != null && emp.getEmployeeType() == EmployeeType.USER) {
			response.sendRedirect("userdash.jsp");
		}else {
			request.setAttribute("error", "Invalid Login Credentials");
			request.getRequestDispatcher("login/login.jsp").forward(request, response);;
			//rd.include(request, response);
			
		}
		
	}

}
