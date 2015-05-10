package BenutzerSchutz;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class VerschluesselnTest {

	@Test
	public void test() throws NoSuchAlgorithmException {
		Passwort_Schutz test=new Passwort_Schutz();
		/**
		 * Passwort ist hier ein leererer String
		 */
		String output=Passwort_Schutz.Verschluesseln("");
		/**
		 * Der SHA-512-Wert eines leeren Strings
		 */
		assertEquals("cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e",output);
		
		
	}

}
