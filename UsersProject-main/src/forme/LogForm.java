package forme;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogForm {
HttpServletRequest request;
private String login;
private String password;
public LogForm(HttpServletRequest request) {
	super();
	this.request = request;
}
public boolean login() {
	String login = (String)request.getParameter("login");
	String password = (String)request.getParameter("password");
	if (login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("passer")) {
		return true;
	}
	else {
		request.setAttribute("connectionFailed", true);
	}
	return false;
}
public void logout(HttpSession session) {
	session = request.getSession();
	session.invalidate();
}

}
