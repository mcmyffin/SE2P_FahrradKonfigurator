package Benutzer;

public interface IBenutzerMail {
	
	/**
	 * 
	 * @return Benuzter E-Mail Adresse 
	 */
	public String getEMail();
	
	/**
	 * 
	 * @param EMail
	 * @return Ob E-Mail Adresse gültig oder nicht
	 */
	   public static boolean GueltigeEMail(String EMail) {
		return false;
	}
	  

}
