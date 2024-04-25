package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet({"/login", "/logout"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_LOGIN = "/WEB-INF/login.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "/login":
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		case "/logout":
			request.getSession().invalidate();
			response.sendRedirect("login");
			break;

		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if ("admin".equals(login) && "passer".equals(password)) {
			request.getSession().setAttribute("isConnected", true);
			response.sendRedirect("list");
		} else {
			request.setAttribute("loginFailled", true);
			request.setAttribute("login", login);
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		}
	}

}
