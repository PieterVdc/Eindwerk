package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MateriaalCategorieDAO;
import dao.MateriaalDAO;
import dto.Materiaal;

/**
 * Servlet implementation class login
 */
@WebServlet("/materiaalbeheer")
public class MateriaalBeheer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MateriaalBeheer() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loggedIn")== null || !(boolean)(request.getSession().getAttribute("loggedIn"))){
			response.sendRedirect("login");
			return;
		}
		
		
		MateriaalDAO materiaalDAO = new MateriaalDAO();
		MateriaalCategorieDAO materiaalCategorieDAO = new MateriaalCategorieDAO();
		
		if (request.getParameter("delete") != null) {
			int delete = Integer.parseInt(request.getParameter("delete"));
			materiaalDAO.delete(delete);
		}else if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			request.setAttribute("matId", edit);
			request.setAttribute("editMat", materiaalDAO.getMateriaal(edit));
			System.out.println(materiaalDAO.getMateriaal(edit).getNaam());
		}else{
			request.setAttribute("matId", -1);
		}
		request.setAttribute("pagename", "MateriaalBeheer");
		request.setAttribute("title", "materiaal beheer");
		request.setAttribute("matList", materiaalDAO.getMaterialen());
		request.setAttribute("soortList", materiaalCategorieDAO.getMateriaalCategorieen());
		request.getRequestDispatcher("/WEB-INF/JSP/base.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int soort = Integer.parseInt(request.getParameter("soort"));
		String naam = request.getParameter("naam");
		String eenheidsmaat = request.getParameter("eenheidsmaat");
		float eenheidsprijs = Float.parseFloat(request.getParameter("eenheidsprijs"));
		if(naam!=null && eenheidsmaat!=null){
			MateriaalDAO materiaalDAO = new MateriaalDAO();
			Materiaal materiaal = new Materiaal(id, naam, eenheidsmaat, eenheidsprijs, soort);
			materiaalDAO.insert(materiaal);
		}
		
		
		doGet(request, response);
	}

}
