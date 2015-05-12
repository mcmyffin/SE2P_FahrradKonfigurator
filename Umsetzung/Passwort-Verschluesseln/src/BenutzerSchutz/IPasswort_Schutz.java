package BenutzerSchutz;

import java.security.NoSuchAlgorithmException;

public interface IPasswort_Schutz {
	
	
	public String Verschluesseln(String Passwort) throws NoSuchAlgorithmException ;
	/**
	 * Methode um Passwort zu verschluesslen 
	 * @param Passwort vom Benutzer 
	 */
}
