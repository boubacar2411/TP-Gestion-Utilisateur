package forme;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;

public class ValidationForm {

	private static final String EMPTY_FIELD_ERROR = "Ce champs doit etre renseigne";
	private static final String DIFFERENT_PASSWORD_FIELD_ERROR = "Les deux mots de passe ne sont pas identiques ";
	private HttpServletRequest request;
	private Map<String, String> erreurs;
	private Utilisateur utilisateur;
	private   boolean status;
	private String statusMessage;
	public ValidationForm(HttpServletRequest request, Map<String, String> erreurs, boolean status,
			String statusMessage) {
		super();
		this.request = request;
		this.erreurs = erreurs;
		this.status = status;
		this.statusMessage = statusMessage;
	}
	public ValidationForm() {
		// TODO Auto-generated constructor stub
	}

	public  static String getParameter(HttpServletRequest request,String parametre) {
		String valeur = request.getParameter(parametre);
		return (valeur == null || valeur.trim().isEmpty()) ? null : valeur.trim();
		
	}
	public  static  void validerChamps(HttpServletRequest request,Map<String, String> erreurs,String... champs) {
		for(String champ : champs) {
			if(getParameter(request,champ)== null) {
				erreurs.put(champ,EMPTY_FIELD_ERROR);
				//System.out.println(EMPTY_FIELD_ERROR+" pour champs "+champ);
			}
		}
	}


	public  static void validerPasswords(HttpServletRequest request,Map<String, String> erreurs,String password,String passwordBis) {
		 if(getParameter(request,password) != null && !getParameter(request,password).equals(getParameter(request,passwordBis))) {
			 erreurs.put(password,DIFFERENT_PASSWORD_FIELD_ERROR);
		 }
	}
}
