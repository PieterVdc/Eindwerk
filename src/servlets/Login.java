package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Login() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("loggedIn", false);
		request.getSession().setAttribute("currentUser", null);
		request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.setPassword("admin", "admin");
		String user = request.getParameter("user");
		String password = request.getParameter("pw");
		
		if (loginDAO.checkCombo(user,password)) {
			request.getSession().setAttribute("loggedIn", true);
			request.getSession().setAttribute("currentUser", user);
			response.sendRedirect("opdrachtbeheer");
			return;
		} else {
			request.setAttribute("invalid", true);
			doGet(request, response);
		}
	}

}
