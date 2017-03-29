package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MateriaalDAO;
import dao.TaakTypeDAO;
import dto.TaakType;

/**
 * Servlet implementation class login
 */
@WebServlet("/taakbeheer")
public class TaakBeheer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TaakBeheer() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loggedIn")== null || !(boolean)(request.getSession().getAttribute("loggedIn"))){
			response.sendRedirect("login");
			return;
		}
		
		
		TaakTypeDAO taakTypeDAO = new TaakTypeDAO();
		
		if (request.getParameter("delete") != null) {
			int delete = Integer.parseInt(request.getParameter("delete"));
			taakTypeDAO.delete(delete);
			request.setAttribute("editId", -1);
		}else if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			request.setAttribute("editId", edit);
			request.setAttribute("editTaak", taakTypeDAO.getTaakType(edit));
		}else{
			request.setAttribute("editId", -1);
		}
		
		MateriaalDAO materiaalDAO = new MateriaalDAO();
		
		request.setAttribute("matList", materiaalDAO.getMaterialen());
		request.setAttribute("pagename", "TaakBeheer");
		request.setAttribute("title", "taak beheer");
		request.setAttribute("taakList", taakTypeDAO.getTaakTypes());
		request.getRequestDispatcher("/WEB-INF/JSP/base.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String naam = request.getParameter("naam");
		String[] materialStringList = request.getParameterValues("materials");
		ArrayList<Integer> materialList = new ArrayList<>();
		if(materialStringList != null){
			for (String string : materialStringList) {
				materialList.add(Integer.parseInt(string));
			}
		}
		
		if(naam!=null){
			TaakTypeDAO taakTypeDAO = new TaakTypeDAO();
			TaakType taakType = new TaakType(id, naam,materialList);
			taakTypeDAO.insert(taakType);
			
		}
		
		
		doGet(request, response);
	}

}
