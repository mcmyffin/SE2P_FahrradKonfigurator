package TeileKomponente;

import models.Exception.EinzelteileTypException;
import models.Exception.ValuesCreateException;
import models.TeileKomponente.EinzelTeileTyp;
import models.TeileKomponente.Einzelteile.Values;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dima on 25.05.15.
 */
public class ValuesTest {



//    @BeforeClass
//    public void beforeClass(){
//
//    }

    // Positiver Test auf Uebereinstimmung der EinzelteileTypen
    @Test
    public void testValuesAufEinzelteileTyp() throws ValuesCreateException {

        int id = 1;
        int formTypID = 1;
        int beschreibungID = 1;
        String farben = "blau#grün#lila";
        String hoehen = "12#22#144";
        int form = 1;
        int reifengroesse = 100;
        int steuersatz = 22;
        int schaftshoehe = 13;
        int zusatzbefest = 12;
        int tretlager = 18;
        int formTyp = 1;
        int preis = 100;
        int schaftslaenge = 1;
        int durchmesser = 2;
        String name = "mokupName";
        String bild = "/mokupPfad/mokupBild.png";
        boolean scheibenbremse = true;
        boolean felgenbremse = true;
        boolean gepaektraeger = true;
        boolean licht = true;
        boolean narbenDynamo = true;
        boolean zusatzBeleg = true;



        // Positive Tests
        assertEquals(Values.createFelge(id,beschreibungID,preis,reifengroesse,formTyp,formTypID,bild,name,narbenDynamo).getEinzelTeileTyp() , EinzelTeileTyp.FELGE);
        assertEquals(Values.createGabel(id, beschreibungID, formTyp, formTypID, schaftslaenge, steuersatz, reifengroesse, preis,
                felgenbremse, scheibenbremse, licht, bild, name).getEinzelTeileTyp() , EinzelTeileTyp.GABEL);

        assertEquals(Values.createMantel(id, beschreibungID, formTyp, formTypID, durchmesser, reifengroesse, preis, bild,
                name).getEinzelTeileTyp(), EinzelTeileTyp.MANTEL);

        assertEquals(Values.createRahmen(id, hoehen, form, reifengroesse, bild, beschreibungID, steuersatz, schaftshoehe, zusatzbefest, scheibenbremse,
                felgenbremse, tretlager, formTyp, formTypID, name, preis, gepaektraeger, licht,farben).getEinzelTeileTyp(), EinzelTeileTyp.RAHMEN);

        assertEquals(Values.createSattel(id, name, beschreibungID, preis, formTyp, formTypID, bild).getEinzelTeileTyp(), EinzelTeileTyp.SATTEL);

        assertEquals(Values.createVorbau(id, beschreibungID, preis, schaftshoehe, formTyp, formTypID, bild).getEinzelTeileTyp(), EinzelTeileTyp.VORBAU);

        assertEquals(Values.createZubehoer(id,beschreibungID,preis,formTyp,formTypID,bild,name,zusatzBeleg).getEinzelTeileTyp(), EinzelTeileTyp.ZUBEHOER);
    }

    // Negativer Test auf ungueltige ID's
    @Test(expected = ValuesCreateException.class)
    public void testValuesAufUngueltigeIDs_0() throws ValuesCreateException {

        int id = 0;
        int formTypID = 0;
        int beschreibungID = 0;
        String farben = "blau#grün#lila";
        String hoehen = "12#22#144";
        int form = 1;
        int reifengroesse = 100;
        int steuersatz = 22;
        int schaftshoehe = 13;
        int zusatzbefest = 12;
        int tretlager = 18;
        int formTyp = 1;
        int preis = 100;
        int schaftslaenge = 1;
        int durchmesser = 2;
        String name = "mokupName";
        String bild = "/mokupPfad/mokupBild.png";
        boolean scheibenbremse = true;
        boolean felgenbremse = true;
        boolean gepaektraeger = true;
        boolean licht = true;
        boolean narbenDynamo = true;
        boolean zusatzBeleg = true;


        // Positive Tests
        assertEquals(Values.createFelge(id,beschreibungID,preis,reifengroesse,formTyp,formTypID,bild,name,narbenDynamo).getEinzelTeileTyp() , EinzelTeileTyp.FELGE);
        assertEquals(Values.createGabel(id, beschreibungID, formTyp, formTypID, schaftslaenge, steuersatz, reifengroesse, preis,
                felgenbremse, scheibenbremse, licht, bild, name).getEinzelTeileTyp() , EinzelTeileTyp.GABEL);

        assertEquals(Values.createMantel(id, beschreibungID, formTyp, formTypID, durchmesser, reifengroesse, preis, bild,
                name).getEinzelTeileTyp(), EinzelTeileTyp.MANTEL);

        assertEquals(Values.createRahmen(id, hoehen, form, reifengroesse, bild, beschreibungID, steuersatz, schaftshoehe, zusatzbefest, scheibenbremse,
                felgenbremse, tretlager, formTyp, formTypID, name, preis, gepaektraeger, licht,farben).getEinzelTeileTyp(), EinzelTeileTyp.RAHMEN);

        assertEquals(Values.createSattel(id, name, beschreibungID, preis, formTyp, formTypID, bild).getEinzelTeileTyp(), EinzelTeileTyp.SATTEL);

        assertEquals(Values.createVorbau(id, beschreibungID, preis, schaftshoehe, formTyp, formTypID, bild).getEinzelTeileTyp(), EinzelTeileTyp.VORBAU);

        assertEquals(Values.createZubehoer(id,beschreibungID,preis,formTyp,formTypID,bild,name,zusatzBeleg).getEinzelTeileTyp(), EinzelTeileTyp.ZUBEHOER);
    }

    // Negativer Test auf ungueltige ID's
   @Test(expected = ValuesCreateException.class)
    public void testValuesAufUngueltigeIDs_1() throws ValuesCreateException {

        int id = -1;
        int formTypID = -1;
        int beschreibungID = -1;
        String farben = "blau#grün#lila";
        String hoehen = "12#22#144";
        int form = 1;
        int reifengroesse = 100;
        int steuersatz = 22;
        int schaftshoehe = 13;
        int zusatzbefest = 12;
        int tretlager = 18;
        int formTyp = 1;
        int preis = 100;
        int schaftslaenge = 1;
        int durchmesser = 2;
        String name = "mokupName";
        String bild = "/mokupPfad/mokupBild.png";
        boolean scheibenbremse = true;
        boolean felgenbremse = true;
        boolean gepaektraeger = true;
        boolean licht = true;
        boolean narbenDynamo = true;
        boolean zusatzBeleg = true;


        // Positive Tests
        assertEquals(Values.createFelge(id,beschreibungID,preis,reifengroesse,formTyp,formTypID,bild,name,narbenDynamo).getEinzelTeileTyp() , EinzelTeileTyp.FELGE);
        assertEquals(Values.createGabel(id, beschreibungID, formTyp, formTypID, schaftslaenge, steuersatz, reifengroesse, preis,
                felgenbremse, scheibenbremse, licht, bild, name).getEinzelTeileTyp() , EinzelTeileTyp.GABEL);

        assertEquals(Values.createMantel(id, beschreibungID, formTyp, formTypID, durchmesser, reifengroesse, preis, bild,
                name).getEinzelTeileTyp(), EinzelTeileTyp.MANTEL);

        assertEquals(Values.createRahmen(id, hoehen, form, reifengroesse, bild, beschreibungID, steuersatz, schaftshoehe, zusatzbefest, scheibenbremse,
                felgenbremse, tretlager, formTyp, formTypID, name, preis, gepaektraeger, licht,farben).getEinzelTeileTyp(), EinzelTeileTyp.RAHMEN);

        assertEquals(Values.createSattel(id, name, beschreibungID, preis, formTyp, formTypID, bild).getEinzelTeileTyp(), EinzelTeileTyp.SATTEL);

        assertEquals(Values.createVorbau(id, beschreibungID, preis, schaftshoehe, formTyp, formTypID, bild).getEinzelTeileTyp(), EinzelTeileTyp.VORBAU);

        assertEquals(Values.createZubehoer(id,beschreibungID,preis,formTyp,formTypID,bild,name,zusatzBeleg).getEinzelTeileTyp(), EinzelTeileTyp.ZUBEHOER);
    }


}
