package forme;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class UpdateUserForm {
	private static final String CHAMP_NOM ="nom";
	private static final String CHAMP_PRENOM ="prenom";
	private static final String CHAMP_LOGIN ="login";
	private static final String CHAMP_PASSWORD ="password";
	private static final String CHAMP_PASSWORD_BIS ="passwordBis";
	private static final String ECHEC_AJOUT_MESSAGE ="Echec de la mise a jour ";
	private static final String SUCCESS_AJOUT_MESSAGE ="Mise a jour  efectuee avec succes !!";
	private HttpServletRequest request;
	private Map<String, String> erreurs;
	private Utilisateur utilisateur;
	private boolean status;
	private String statusMessage;
	public UpdateUserForm(HttpServletRequest request) {
		this.request= request;
		this.status = false;
		this.statusMessage = ECHEC_AJOUT_MESSAGE;
		this.erreurs = new HashMap<String, String>();
	}
	public boolean modifier() {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = ValidationForm.getParameter(request,CHAMP_NOM);
		String prenom= ValidationForm.getParameter(request,CHAMP_PRENOM);
		String login= ValidationForm.getParameter(request,CHAMP_LOGIN);
		String password = ValidationForm.getParameter(request,CHAMP_PASSWORD);
		this.utilisateur = new Utilisateur(id,nom, prenom, login, password);
		ValidationForm.validerChamps(request,erreurs,CHAMP_NOM,CHAMP_PRENOM,CHAMP_LOGIN,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		//System.out.print(nom+" "+prenom+" "+login+" "+password);
		ValidationForm.validerPasswords(request,erreurs,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		if(this.erreurs.isEmpty()) {
			 UtilisateurDao.modifier(utilisateur);
			this.status=true;
			this.statusMessage= SUCCESS_AJOUT_MESSAGE ;
		}
				return this.status;
	}
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public boolean isStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

}
