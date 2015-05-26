package TeileKomponente;

import junit.framework.TestCase;
import models.Exception.EinzelteileTypException;
import models.TeileKomponente.EinzelTeileTyp;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by dima on 25.05.15.
 */
public class EinzelteileTypTest {

    @Test
    public void testGetEinzelteileTypByStringPositiv() throws EinzelteileTypException {

        // Positive Tests
        assertEquals(EinzelTeileTyp.FELGE,  EinzelTeileTyp.getEinzelteileTypByString("Felge"));
        assertEquals(EinzelTeileTyp.GABEL,  EinzelTeileTyp.getEinzelteileTypByString("Gabel"));
        assertEquals(EinzelTeileTyp.MANTEL, EinzelTeileTyp.getEinzelteileTypByString("Mantel"));
        assertEquals(EinzelTeileTyp.RAHMEN, EinzelTeileTyp.getEinzelteileTypByString("Rahmen"));
        assertEquals(EinzelTeileTyp.SATTEL, EinzelTeileTyp.getEinzelteileTypByString("Sattel"));
        assertEquals(EinzelTeileTyp.VORBAU, EinzelTeileTyp.getEinzelteileTypByString("Vorbau"));
    }

    @Test(expected = EinzelteileTypException.class)
    public void testGetEinzelteileTypByStringGrenzwerte() throws EinzelteileTypException {

        //negative Tests
        EinzelTeileTyp.getEinzelteileTypByString(null);
        EinzelTeileTyp.getEinzelteileTypByString("");
        EinzelTeileTyp.getEinzelteileTypByString("felge");
        EinzelTeileTyp.getEinzelteileTypByString("gabel");
        EinzelTeileTyp.getEinzelteileTypByString("mantel");
        EinzelTeileTyp.getEinzelteileTypByString("rahmen");
        EinzelTeileTyp.getEinzelteileTypByString("sattel");
        EinzelTeileTyp.getEinzelteileTypByString("vorbau");

    }
}
