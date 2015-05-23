package Benutzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class BenutzerMail implements IBenutzerMail  {
	
	private String EMail;

	/**
	 * Konstruktur mit throws Exception falls die EMail nicht gültich ist
	 * @param EMail
	 * @throws Exception
	 */
   
	public  BenutzerMail(String EMail) throws Exception{
		if(!GueltigeEMail(EMail)){
		throw new Exception("Die eingegebene E-Mail Adresse ist nicht gültich");
	}
		this.EMail=EMail;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public String getEMail() {
		return EMail;
	}
	
	/**
     * Prüft EMail Adresse gültich.
     * @pre EMail != null
     * @param EMail
     * @return EMail Adresse oder false
     */

	public static boolean GueltigeEMail(String EMail) {
		if(EMail==null){
		return false;
	}
		Pattern p = Pattern.compile("[a-z0-9]+@[a-z0-9]+\\.[a-z]+"); 
        Matcher m = p.matcher((CharSequence) EMail); 
        return m.matches(); 
	}

	


	
}
