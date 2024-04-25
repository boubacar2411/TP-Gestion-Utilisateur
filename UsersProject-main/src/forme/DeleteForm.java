package forme;


import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class DeleteForm {
	private HttpServletRequest request;
	private boolean status;
	private String statusMessage;
	private Utilisateur utilisateur;
	private static final String ECHEC_SUPPRESSION_MESSAGE ="Echec de la suppression";
	private static final String SUCCESS_SUPPRESSION_MESSAGE ="Utilisateur supprime avec succes !!";
	
	public DeleteForm(HttpServletRequest request) {
		this.request= request;
		this.status = false;
		this.statusMessage = ECHEC_SUPPRESSION_MESSAGE;
	}
	public boolean supprimer() {		
		String id= request.getParameter("id");
		if(id!=null && id.matches("[0-9]+")) {
			Utilisateur  user = UtilisateurDao.get(Integer.parseInt(id));
			if(user!=null) {
				UtilisateurDao.supprimer(Integer.parseInt(id));
				this.status=true;
				this.statusMessage= SUCCESS_SUPPRESSION_MESSAGE ;
			}
			else {
				this.statusMessage +=" cet utilisateur ne figure pas dans la base";
			}
		}
		return this.status;
		
	}
	public boolean isStatus() {
		return status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
}
