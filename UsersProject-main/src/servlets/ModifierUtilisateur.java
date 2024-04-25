package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;
import forme.UpdateUserForm;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/modifier")
public class ModifierUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_MODIFIER_UTILISATEUR = "/WEB-INF/UpdateUser.jsp";
	//private static final String VUE_LIST_UTILISATEUR = "/WEB-INF/listerUtilisateur.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null && id.matches("[0-9]+")) {

			Utilisateur utilisateur = UtilisateurDao.get(Integer.parseInt(id));
			if (utilisateur != null) {
				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher(VUE_MODIFIER_UTILISATEUR).forward(request, response);
				return;
			}

		}
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UpdateUserForm form= new UpdateUserForm(request);
		request.setAttribute("statusMessage", form.getStatusMessage());
		if(form.modifier()) {
			response.sendRedirect("list");
			//getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
		}
	
		else {
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("utilisateur", form.getUtilisateur());
			request.setAttribute("erreurs", form.getErreurs());
			getServletContext().getRequestDispatcher(VUE_MODIFIER_UTILISATEUR).forward(request, response);
		}
	}

}