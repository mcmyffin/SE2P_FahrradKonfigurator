import junit.framework.TestCase;
import models.DatenBank.DataC;
import models.DatenBank.IDatenBank;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import play.db.*;

/**
 * Created by tin on 30.04.15.
 */
public class DBKundeTest extends TestCase {
    IDatenBank _db1;

    @Before
    public void setUp() throws Exception{
        _db1 = DataC.setTestEnv();
    }

    public void testIsKundeExistByMail() throws Exception {
        //Assert True evaluation
        assertTrue(_db1.isKundeExistByMail("dada@dumdum.de"));

        //Assert False evaluation
        assertFalse(_db1.isKundeExistByMail("hullu"));
        assertFalse(_db1.isKundeExistByMail("12345"));
        assertFalse(_db1.isKundeExistByMail(""));
        assertFalse(_db1.isKundeExistByMail("hihihih"));
    }

    public void testGetKundeByID() throws Exception {
        //Eine testliste erstellen mit den gegebenen werten, die in der Datenbank stehen
        List<String> testList= new ArrayList<String>();
        List<String> testList2= new ArrayList<String>();
        testList.add("1");
        testList.add("dada@dumdum.de");
        testList.add("Dumdum");
        testList.add("123");
        testList.add("Dada");

        //Assert True evaluation
        assertEquals(testList,_db1.getKundeByID(1));
        assertEquals(testList2, _db1.getKundeByID(0));

        //Assert False evaluation
        assertNotSame(testList,_db1.getKundeByID(0));
        assertNotSame(testList2,_db1.getKundeByID(1));
    }

    public void testGetKundeIDByLogin() throws Exception {

        //Assert True evaluation
        assertEquals(1, _db1.getKundeIDByLogin("dada@dumdum.de", "kenntKeiner"));
        assertEquals(0, _db1.getKundeIDByLogin("Halluuuuuu", "heehehhehe"));


        //Assert False evaluation
        assertNotSame(0,_db1.getKundeIDByLogin("dada@dumdum.de","kenntKeiner"));
        assertNotSame(12, _db1.getKundeIDByLogin("dada@dumdum.de", "kenntKeiner"));
        assertNotSame(1,_db1.getKundeIDByLogin("", ""));
    }

    public void testGetAdressByID() throws Exception {
        //Erstellen einiger Testlisten
        List<String> testList = new ArrayList<String>();
        List<String> testList2 = new ArrayList<String>();
        testList.add("Dada Straße");
        testList.add("1");
        testList.add("10000");
        testList.add("Dadamstadt");
        testList.add("Damnit!");

        //Assert True evaluation
        assertEquals(testList,_db1.getAdressByID(1));
        assertEquals(testList2, _db1.getAdressByID(0));

        //Assert False evaluation
        assertNotSame(testList, _db1.getAdressByID(0));
        assertNotSame(testList2, _db1.getAdressByID(1));

    }

    public void testSetVorname() throws Exception {

        //Assert True evaluation
        assertTrue(_db1.setVorname(1, "Dada"));

        //Assert False evaluation
        assertFalse(_db1.setVorname(0, "Dada"));
        assertFalse(_db1.setVorname(1, ""));

    }

    public void testSetNachname() throws Exception {

        //Assert True evaluation
        assertTrue(_db1.setNachname(1, "Dumdum"));

        //Assert False evaluation
        assertFalse(_db1.setNachname(0, "Dada"));
        assertFalse(_db1.setNachname(1, ""));
    }

    public void testSetAdresse() throws Exception {
        //Erzeugen einiger Test listen
        List<String> testList = new ArrayList<String>();
        List<String> testList2 = new ArrayList<String>();
        testList.add("Dada Straße");
        testList.add("1");
        testList.add("10000");
        testList.add("Dadamstadt");
        testList.add("Damnit!");

        //Assert True evaluation
        assertTrue(_db1.setAdresse(1, testList));

        //Assert False evaluation
        assertFalse(_db1.setAdresse(0, testList));
        assertFalse(_db1.setAdresse(1, testList2));
    }

    public void testSetEMail() throws Exception {

        //Assert True evaluation
        assertTrue(_db1.setEMail(1, "dada@dumdum.de"));

        //Assert False evaluation
        assertFalse(_db1.setEMail(1,""));
        assertFalse(_db1.setEMail(0,"heeeehehhe"));
    }

    public void testSetPasswort() throws Exception {

        //Assert True evaluation
        assertTrue(_db1.setPasswort(1, "kenntKeiner"));

        //Assert False evaluation
        assertFalse(_db1.setPasswort(1, ""));
        assertFalse(_db1.setPasswort(0,"aasdgfar"));

    }
}