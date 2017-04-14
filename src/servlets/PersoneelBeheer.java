package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WerknemerDAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/personeelbeheer")
public class PersoneelBeheer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PersoneelBeheer() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loggedIn")== null || !(boolean)(request.getSession().getAttribute("loggedIn"))){
			response.sendRedirect("login");
			return;
		}
		
		
		WerknemerDAO werknemerDAO = new WerknemerDAO();
		
		request.setAttribute("pagename", "PersoneelBeheer");
		request.setAttribute("title", "Personeel beheer");
		request.setAttribute("PersoneelList", werknemerDAO.getWerknemers());
		request.getRequestDispatcher("/WEB-INF/JSP/base.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
