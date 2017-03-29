package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KlantDAO;
import dto.Klant;
import dto.Particulier;

/**
 * Servlet implementation class login
 */
@WebServlet("/KlantDetail")
public class KlantDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public KlantDetail() {
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
		
		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Klant klant = klantDAO.getKlant(edit);
			if(klant instanceof Particulier){
				request.setAttribute("type", "particulier");
			}else{
				request.setAttribute("type", "bedrijf");
			}
			request.setAttribute("klant", klant);
		}
		
		
		request.setAttribute("pagename", "KlantDetail");
		request.setAttribute("title", "Klant beheer");
		request.getRequestDispatcher("/WEB-INF/JSP/base.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
