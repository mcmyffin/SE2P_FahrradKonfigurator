package Benutzer;

import static org.junit.Assert.*;

import org.junit.Test;

public class IBenutzerMailTest {

	@Test(expected=Exception.class) 
	public void testBenutzerMail() throws Exception {
		IBenutzerMail EMail ;
		EMail=new BenutzerMail("test"); 
	}

	@Test
	public void testGetEMail() {
		try { 
 			String EMailTest = "MeinEMail@hotmail.de"; 
 			IBenutzerMail EMail = new BenutzerMail(EMailTest); 
 			 
 			assertEquals(EMailTest, EMail.getEMail()); 
 			 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
	}

	@Test
	public void testGueltigeEMail() {
		
		assertTrue(BenutzerMail.GueltigeEMail("test@test.test"));
		assertFalse(BenutzerMail.GueltigeEMail(null)); 
 		assertFalse(BenutzerMail.GueltigeEMail("test")); 
 		assertFalse(BenutzerMail.GueltigeEMail("test@hotmail@de")); 
 		assertFalse(BenutzerMail.GueltigeEMail("test.test")); 
 		assertFalse(BenutzerMail.GueltigeEMail("www.test.com")); 
 		 
 		 
	}

}

