package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KlantDAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/facturatiebeheer")
public class FacturatieBeheer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FacturatieBeheer() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loggedIn")== null || !(boolean)(request.getSession().getAttribute("loggedIn"))){
			response.sendRedirect("login");
			return;
		}
		
		
		KlantDAO klantDAO = new KlantDAO();
		
		request.setAttribute("pagename", "Facturatie");
		request.setAttribute("title", "Klant beheer");
		request.setAttribute("bedrijfList", klantDAO.getBedrijven());
		request.setAttribute("particulierList", klantDAO.getParticulieren());
		request.getRequestDispatcher("/WEB-INF/JSP/base.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
