package models.DatenBank;

import junit.framework.TestCase;
import models.TeileKomponente.Einzelteile.*;
import org.junit.Before;

import java.util.List;

/**
 * Created by tin on 15.06.15.
 */
public class DataCTest extends TestCase {
    IDBAlleTeile _testDB;

    @Before
    public void setUp() throws Exception{
        _testDB = DataC.setTestEnv();
    }


    public void testGetFelgeByID() throws Exception {
        List<Felge> myList = _testDB.getAllFelgen();
        for(Felge currFelge : myList) {
            Felge testFelge = _testDB.getFelgeByID(currFelge.getId());
            assertEquals(currFelge.getBeschreibungID(),testFelge.getBeschreibungID());
            assertEquals(currFelge.getFormTyp(),testFelge.getFormTyp());
            assertEquals(currFelge.getFormTypID(),testFelge.getFormTypID());
            assertEquals(currFelge.getId(),testFelge.getId());
            assertEquals(currFelge.getPreis(),testFelge.getPreis());
            assertEquals(currFelge.getReifengroesse(),testFelge.getReifengroesse());
            assertEquals(currFelge.getBild(),testFelge.getBild());
            assertEquals(currFelge.getName(),testFelge.getName());
            assertEquals(currFelge.isNarbendynamo(), testFelge.isNarbendynamo());

        }
    }

    public void testGetAllFelgen() throws Exception {
        List<Felge> myList = _testDB.getAllFelgen();
        for(Felge currFelge : myList){
            assertNotNull(currFelge);
        }
    }

    public void testGetFelgeByFormTyp() throws Exception {
        List<Felge> myList = _testDB.getFelgeByFormTyp(28);
        for (Felge currFelge : myList){
            assertEquals(currFelge.getFormTyp(), 28);
        }

        myList = _testDB.getFelgeByFormTyp(26);
        for (Felge currFelge : myList){
            assertEquals(currFelge.getFormTyp(), 26);
        }

        myList = _testDB.getFelgeByFormTyp(-1);
        assertTrue(myList.isEmpty());

    }

    public void testGetGabelnByID() throws Exception {
        List<Gabel> myList = _testDB.getAllGabel();
        for(Gabel currGabel : myList) {
            Gabel testGabel = _testDB.getGabelnByID(currGabel.getId());
            assertEquals(currGabel.getBeschreibungID(),testGabel.getBeschreibungID());
            assertEquals(currGabel.getBild(),testGabel.getBild());
            assertEquals(currGabel.getFormTypID(),testGabel.getFormTypID());
            assertEquals(currGabel.getFromTyp(),testGabel.getFromTyp());
            assertEquals(currGabel.getId(),testGabel.getId());
            assertEquals(currGabel.getName(),testGabel.getName());
            assertEquals(currGabel.getPreis(),testGabel.getPreis());
            assertEquals(currGabel.getReifengroesse(),testGabel.getReifengroesse());
            assertEquals(currGabel.getSchaftslaenge(),testGabel.getSchaftslaenge());
            assertEquals(currGabel.getSteuersatz(),testGabel.getSteuersatz());
            assertEquals(currGabel.isFelgenbremse(),testGabel.isFelgenbremse());
            assertEquals(currGabel.isLicht(),testGabel.isLicht());
            assertEquals(currGabel.isScheibenbremse(),testGabel.isScheibenbremse());

        }

    }

    public void testGetAllGabel() throws Exception {
        List<Gabel> myList = _testDB.getAllGabel();
        for(Gabel currGabel : myList){
            assertNotNull(currGabel);
        }
    }

    public void testGetGabelByFormTyp() throws Exception {
        int FIRST_KONST = 1;
        int SECOND_KONST = 18;
        List<Gabel> myList = _testDB.getGabelByFormTyp(FIRST_KONST);
        for(Gabel currGabel : myList){
            assertEquals(currGabel.getFromTyp(),FIRST_KONST);
        }
        myList = _testDB.getGabelByFormTyp(SECOND_KONST);
        for(Gabel currGabel : myList){
            assertEquals(currGabel.getFromTyp(), SECOND_KONST);
        }
    }

    public void testGetMantelByID() throws Exception {
        List<Mantel> myList = _testDB.getAllMantel();
        for(Mantel currMantel : myList){
            Mantel testMantel = _testDB.getMantelByID(currMantel.getId());
            assertEquals(currMantel.getBeschreibungID(),testMantel.getBeschreibungID());
            assertEquals(currMantel.getBild(),testMantel.getBild());
            assertEquals(currMantel.getDurchmesser(),testMantel.getDurchmesser());
            assertEquals(currMantel.getFormTyp(),testMantel.getFormTyp());
            assertEquals(currMantel.getFormTypID(),testMantel.getFormTypID());
            assertEquals(currMantel.getId(),testMantel.getId());
            assertEquals(currMantel.getName(),testMantel.getName());
            assertEquals(currMantel.getPreis(),testMantel.getPreis());
            assertEquals(currMantel.getReifengroesse(), testMantel.getReifengroesse());
        }
    }

    public void testGetAllMantel() throws Exception {
        List<Mantel> myList = _testDB.getAllMantel();
        for (Mantel currMantel : myList){
            assertNotNull(currMantel);
        }
    }

    public void testGetMantelByFormTyp() throws Exception {
        int FIRST_CONST = 26;
        int SECOND_KONST = 28;
        int THIRD_KONST = -1;
        List<Mantel> myList = _testDB.getMantelByFormTyp(FIRST_CONST);
        for (Mantel currMantel : myList){
            assertEquals(currMantel.getFormTyp(),FIRST_CONST);
        }
        myList = _testDB.getMantelByFormTyp(SECOND_KONST);
        for (Mantel currMantel : myList){
            assertEquals(currMantel.getFormTyp(),SECOND_KONST);
        }

        myList = _testDB.getMantelByFormTyp(THIRD_KONST);
        assertTrue(myList.isEmpty());
    }

    public void testGetRahmenByFormtyp() throws Exception {
        int FIRST_KONST = 0;
        int SECOND_KONST = 1;
        int THIRD_KONST = 2;
        int FOURTH_KONST = -1;
        List<Rahmen> myList = _testDB.getRahmenByFormtyp(FIRST_KONST);
        assertTrue(!myList.isEmpty());
        for(Rahmen currRahmen : myList){
            assertEquals(currRahmen.getFromTyp(),FIRST_KONST);
        }


        myList = _testDB.getRahmenByFormtyp(SECOND_KONST);
        assertTrue(!myList.isEmpty());
        for(Rahmen currRahmen : myList){
            assertEquals(currRahmen.getFromTyp(),SECOND_KONST);
        }


        myList = _testDB.getRahmenByFormtyp(THIRD_KONST);
        assertTrue(!myList.isEmpty());
        for(Rahmen currRahmen : myList){
            assertEquals(currRahmen.getFromTyp(),THIRD_KONST);
        }

        myList = _testDB.getRahmenByFormtyp(FOURTH_KONST);
        assertTrue(myList.isEmpty());

    }

    public void testGetRahmenByID() throws Exception {
        List<Rahmen> myList = _testDB.getAllRahmen();
        for (Rahmen currRahmen : myList){
            Rahmen testRahmen = _testDB.getRahmenByID(currRahmen.getId());
            assertEquals(currRahmen.getBeschreibungID(),testRahmen.getBeschreibungID());
            assertEquals(currRahmen.getBild(),testRahmen.getBild());
            assertEquals(currRahmen.getFarben(),testRahmen.getFarben());
            assertEquals(currRahmen.getForm(),testRahmen.getForm());
            assertEquals(currRahmen.getFormTypID(),testRahmen.getFormTypID());
            assertEquals(currRahmen.getFromTyp(),testRahmen.getFromTyp());
            assertEquals(currRahmen.getHoehen(),testRahmen.getHoehen());
            assertEquals(currRahmen.getId(),testRahmen.getId());
            assertEquals(currRahmen.getName(),testRahmen.getName());
            assertEquals(currRahmen.getPreis(),testRahmen.getPreis());
            assertEquals(currRahmen.getReifengroesse(),testRahmen.getReifengroesse());
            assertEquals(currRahmen.getSchaftshoehe(),testRahmen.getSchaftshoehe());
            assertEquals(currRahmen.getSteuersatz(),testRahmen.getSteuersatz());
            assertEquals(currRahmen.getTretlager(),testRahmen.getTretlager());
            assertEquals(currRahmen.getZusatzbefest(),testRahmen.getZusatzbefest());
            assertEquals(currRahmen.isFelgenbremse(),testRahmen.isFelgenbremse());
            assertEquals(currRahmen.isGepaektraeger(),testRahmen.isGepaektraeger());
            assertEquals(currRahmen.isLicht(),testRahmen.isLicht());
            assertEquals(currRahmen.isScheibenbremse(),testRahmen.isScheibenbremse());
        }
    }

    public void testGetAllRahmen() throws Exception {
        List<Rahmen> myList = _testDB.getAllRahmen();
        assertTrue(!myList.isEmpty());
        for (Rahmen currRahmen : myList){
            assertNotNull(currRahmen);
        }
    }

    public void testGetSattelByID() throws Exception {
        List<Sattel> myList = _testDB.getAllSattel();
        for (Sattel currSattel : myList){
            Sattel testSattel = _testDB.getSattelByID(currSattel.getId());
            assertEquals(currSattel.getBeschreibungID(),testSattel.getBeschreibungID());
            assertEquals(currSattel.getBild(),testSattel.getBild());
            assertEquals(currSattel.getFormTyp(),testSattel.getFormTyp());
            assertEquals(currSattel.getFormTypID(),testSattel.getFormTypID());
            assertEquals(currSattel.getId(),testSattel.getId());
            assertEquals(currSattel.getName(),testSattel.getName());
            assertEquals(currSattel.getPreis(), testSattel.getPreis());
        }
    }

    public void testGetAllSattel() throws Exception {
        List<Sattel> myList = _testDB.getAllSattel();
        assertTrue(!myList.isEmpty());
        for (Sattel currSattel : myList){
            assertNotNull(currSattel);
        }
    }

    public void testGetTeileByID() throws Exception {
        List<Zubehoer> myList = _testDB.getAllTeile();
        for(Zubehoer currZub : myList){
            Zubehoer testZub = _testDB.getTeileByID(currZub.getId());
            assertEquals(currZub.getBeschreibungID(),testZub.getBeschreibungID());
            assertEquals(currZub.getBild(),testZub.getBild());
            assertEquals(currZub.getFormTyp(),testZub.getFormTyp());
            assertEquals(currZub.getFormTypID(),testZub.getFormTypID());
            assertEquals(currZub.getId(),testZub.getId());
            assertEquals(currZub.getName(),testZub.getName());
            assertEquals(currZub.getPreis(),testZub.getPreis());
            assertEquals(currZub.isZusatzBelegt(), testZub.isZusatzBelegt());
        }
    }

    public void testGetAllTeile() throws Exception {
        List<Zubehoer> myList = _testDB.getAllTeile();
        assertTrue(!myList.isEmpty());
        for (Zubehoer currZub : myList){
            assertNotNull(currZub);
        }
    }

    public void testGetVorbauByID() throws Exception {
        List<Vorbau> myList = _testDB.getAllVorbau();
        for(Vorbau currVorbau : myList ){
            Vorbau testVorbau = _testDB.getVorbauByID(currVorbau.getId());

            assertEquals(currVorbau.getBeschreibungID(),testVorbau.getBeschreibungID());
            assertEquals(currVorbau.getBild(),testVorbau.getBild());
            assertEquals(currVorbau.getFormTyp(),testVorbau.getFormTyp());
            assertEquals(currVorbau.getFormTypID(),testVorbau.getFormTypID());
            assertEquals(currVorbau.getId(),testVorbau.getId());
            assertEquals(currVorbau.getPreis(),testVorbau.getPreis());
            assertEquals(currVorbau.getSchaftsgroesse(), testVorbau.getSchaftsgroesse());
        }
    }

    public void testGetAllVorbau() throws Exception {
        List<Vorbau> myList = _testDB.getAllVorbau();
        assertTrue(!myList.isEmpty());
        for (Vorbau currVorbau : myList){
            assertNotNull(currVorbau);
        }
    }

    public void testGetVorbauByFormTyp() throws Exception {
        int FIRST_KONST = 1;
        int SECOND_KONST = 18;
        int THIRD_KONST = -1;
        List<Vorbau> myList = _testDB.getVorbauByFormTyp(FIRST_KONST);
        assertTrue(!myList.isEmpty());
        for (Vorbau currVorbau : myList){
            assertEquals(FIRST_KONST,currVorbau.getFormTyp());
        }

        myList = _testDB.getVorbauByFormTyp(SECOND_KONST);
        assertTrue(!myList.isEmpty());
        for (Vorbau currVorbau : myList){
            assertEquals(SECOND_KONST,currVorbau.getFormTyp());
        }

        myList = _testDB.getVorbauByFormTyp(THIRD_KONST);
        assertTrue(myList.isEmpty());
    }

    public void testGetBeschreibungByID() throws Exception {
        Beschreibung besch = _testDB.getBeschreibungByID(5);
        assertNotNull(besch);
    }
}