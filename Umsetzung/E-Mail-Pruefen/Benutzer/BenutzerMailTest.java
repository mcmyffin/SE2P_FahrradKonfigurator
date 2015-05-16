package Benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

public class BenutzerMailTest {

	@Test(expected=Exception.class) 
	public void testBenutzerMail() throws Exception {
		BenutzerMail EMail ;
		EMail=new BenutzerMail("test"); 
	}

	@Test
	public void testGetEMail() {
		try { 
 			String EMailTest = "MeinEMail@hotmail.de"; 
 			BenutzerMail EMail = new BenutzerMail(EMailTest); 
 			 
 			assertEquals(EMailTest, EMail.getEMail()); 
 			 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
	}

	@Test
	public void testGueltigeEMail() {
		
		assertTrue(BenutzerMail.GueltigeEMail("m_e-i_ne_e-m-ail@hotmail.de"));
		assertTrue(BenutzerMail.GueltigeEMail("email1475@hotmail.de"));
		assertTrue(BenutzerMail.GueltigeEMail("EMAIL@hotmail.de"));
		assertTrue(BenutzerMail.GueltigeEMail("meine_email@hotmail.de"));



		assertFalse(BenutzerMail.GueltigeEMail(null)); 
 		assertFalse(BenutzerMail.GueltigeEMail("test@@hotmail.com")); 
 		assertFalse(BenutzerMail.GueltigeEMail("test@hotmail;com")); 
 		assertFalse(BenutzerMail.GueltigeEMail("test@test")); 
 		assertFalse(BenutzerMail.GueltigeEMail("www.test.com")); 
 		 
 		 
	}

}

