package BenutzerSchutz;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Passwort_Schutz {
	
		   
		private static  Formatter formatter;
		

		public static  String Verschluesseln (String Passwort) throws NoSuchAlgorithmException{
			/**
			 * MessageDigest ist das Klasse  Verschlüsseln übernimmt,
			 * Wir holen uns mittels der Methode getInstance(String algorithm) eine Instanz mit unserem gewünschten Algorithmus 
			 */	  
			 MessageDigest digest= MessageDigest.getInstance("SHA-512");
			
			/**
			 * Übergebe von der Zeichenkette in Byteform
			 */
			digest.update(Passwort.getBytes());
			 	
			/**
			 * Formatter wird Byte-Array formatieren und den resultierenden String zurück geben
			 */
			 formatter = new Formatter();
			/**
			 * digest() gibt  ein Byte-Array zurück
			 */
			for(byte b:digest.digest()){
			/**
			 * Hexadezimal format
			 */
			formatter.format("%02x",b);
				}
			/**
			 * @return String wird zurückgegeben
			 */
			
			return formatter.toString();
		}
			
		
	 }
			
			
		
		
	 
