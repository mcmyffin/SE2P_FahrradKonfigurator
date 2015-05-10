package daten;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;



 public class Verschluesslung{
	   
	private static Formatter formatter;

	public static String Verschluesseln (String Passwort) throws NoSuchAlgorithmException{
    
		
			
		//MessageDigest ist das Klasse  Verschl�sseln �bernimmt, 
		//Wir holen uns mittels der Methode getInstance(String algorithm) eine Instanz mit unserem gew�nschten Algorithmus  
		 MessageDigest digest= MessageDigest.getInstance("SHA-512");
		
		 //�bergebe von der Zeichenkette in Byteform
			
		    digest.update(Passwort.getBytes());
		 	
			//Formatter wird Byte-Array formatieren und den resultierenden String zur�ck geben
			formatter = new Formatter();
			//digest() gibt  ein Byte-Array zur�ck
			for(byte b:digest.digest()){
				//Hexadezimal format
				formatter.format("%02x",b);
			}
			return formatter.toString();
 }
	///verschl�sselung testen
	public static void main(String[]args) throws NoSuchAlgorithmException{
	
		System.out.println(Verschluesslung.Verschluesseln("123456"));
		
	}
 }