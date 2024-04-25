package forme;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class AddUserForm
{
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	private static final String MESSAGE_ERROR_MESSAGE = "echec de l'ajout !";
	private static final String MESSAGE_SUCCES_MESSAGE = "ajout effectué avec succes !";
	private static final String EMPTY_FILED_ERROR_MESSAGE = "vous devez renseigner ce champ !";
	private static final String DIFFERENT_PASSWORD_ERROR_MESSAGE = "les mots passes ne sont pas conformes";
	
	private HttpServletRequest request;
	private Map<String, String> erreurs;
	private Utilisateur utilisateur;
	private String statusMessage;
	private boolean status;
	
	public AddUserForm(HttpServletRequest request)
	{
		this.status = false;
		this.request = request;
		this.statusMessage = MESSAGE_ERROR_MESSAGE;
		this.erreurs = new HashMap<String, String>();
	}
	public String getParameter(String parametre)
	{
		String valeur = this.request.getParameter(parametre);
		return (valeur == null || valeur.trim().isEmpty() ? null : valeur.trim());
	}
	
	public void validerChamp(String... champs)
	{
		for(String champ: champs)
		{
			if (this.getParameter(champ) == null)
			{
				erreurs.put(champ, EMPTY_FILED_ERROR_MESSAGE);
			}
		}
	}
	
	public void validerPassword()
	{
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);
		
		if (password != null && !password.equals(passwordBis))
		{
			erreurs.put(CHAMP_PASSWORD, DIFFERENT_PASSWORD_ERROR_MESSAGE);
			erreurs.put(CHAMP_PASSWORD_BIS, DIFFERENT_PASSWORD_ERROR_MESSAGE);
		}
	}
	
	public void ajouter()
	{
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		this.utilisateur = new Utilisateur(nom, prenom, login, password);
		this.validerChamp(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD);
		this.validerPassword();
		
		if (this.erreurs.isEmpty())
		{
			UtilisateurDao.ajouter(utilisateur);
			this.status = true;
			this.statusMessage = MESSAGE_SUCCES_MESSAGE;
		}
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public boolean isStatus() {
		return status;
	}
}
