package models.TeileKomponente.Einzelteile;

import models.Exception.ValuesCreateException;
import models.TeileKomponente.Einzelteile.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 24.05.15.
 */
public class Values {

    private static final String STRINGSEPERATOR = "#";


    /**
     * Create Felge
     * Erstellt den DatenTyp Felge, wobei folgende Bedingungen erfuellt seien muessen:
     * @require id > 0 & beschrID > 0 & formTID > 0
     *
     * @param id
     * @param beschrID
     * @param preis
     * @param reifGr
     * @param formT
     * @param formTID
     * @param bild
     * @param name
     * @param narbendynamo
     * @return DatenTyp Felge
     *
     * @throws ValuesCreateException
     *      Wirft eine ValuesCreateException wenn mindestens eine der folgenden Bedingungen eintreffen:
     *
     *      1) Vorbedingung verletzt
     *      2) bild parameter null ist
     *      3) name parameter null ist
     */
    public static Felge createFelge(int id, int beschrID, int preis, int reifGr, int formT, int formTID, String bild, String name, boolean narbendynamo) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id,beschrID,formTID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");
        if(bild == null) throw new ValuesCreateException("Der Parameter 'bild' darf nicht null sein! ");
        if(name == null) throw new ValuesCreateException("Der Parameter 'name' darf nicht null sein! ");

        return Felge.getValue(id,beschrID,preis,reifGr,formT,formTID,bild,name,narbendynamo);
    }


    /**
     * Create Mantel
     * Erstellt den DatenTyp Mantel, wobei folgende Bedingungen erfuellt seien muessen:
     * @require id > 0 & beschrID > 0 & formTID > 0
     * @require durchmesser >= 0 & reifengroesse >= 0
     *
     * @param id
     * @param beschreibungID
     * @param formTyp
     * @param formTypID
     * @param durchmesser
     * @param reifengroesse
     * @param preis
     * @param bild
     * @param name
     * @return DatenTyp Mantel
     *
     * @throws ValuesCreateException
     *          Wirf eine ValuesCreateException wenn mindestens eine der folgenden Bedigungen eintreffen:
     *
     *          1) Vorbedingungen verletzt
     *          2) bild parameter null ist
     *          3) name parameter null ist
     */
    public  static Mantel createMantel(int id, int beschreibungID, int formTyp, int formTypID, int durchmesser, int reifengroesse, int preis, String bild, String name) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id,beschreibungID,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");
        if(bild == null) throw new ValuesCreateException("Der Parameter 'bild' darf nicht null sein! ");
        if(name == null) throw new ValuesCreateException("Der Parameter 'name' darf nicht null sein! ");

        return Mantel.getValue(id,beschreibungID,formTyp,formTypID,durchmesser,reifengroesse,preis,bild,name);
    }


    /**
     * Create Rahmen
     * * Erstellt den DatenTyp Mantel, wobei folgende Bedingungen erfuellt seien muessen:
     * @require id > 0 & beschrID > 0 & formTID > 0
     * @require hoehe >= 0 & reifengroesse >= 0 & steuersatz >= 0 & schaftsgroesse >= 0 & zusatzbefest >= 0
     * @require tretlager >= 0 & formTyp >= 0
     *
     * @param id
     * @param hoehen
     * @param form
     * @param reifengroesse
     * @param bild
     * @param beschreibungID
     * @param steuersatz
     * @param schaftshoehe
     * @param zusatzbefest
     * @param scheibenbremse
     * @param felgenbremse
     * @param tretlager
     * @param fromTyp
     * @param formTypID
     * @param name
     * @param preis
     * @param gepaektraeger
     * @param licht
     * @param farben
     * @return DatenTyp Rahmen
     *
     * @throws ValuesCreateException
     *
     *          Wirf eine ValuesCreateException wenn mindestens eine der folgenden Bedigungen eintreffen:
     *
     *          1) Vorbedingungen verletzt
     *          2) name parameter null ist
     *          3) bild parameter null ist
     *          4) heohen parameter null ist
     *          5) farben parameter null ist
     *          6) keine hoehen vorhanden sind
     *          7) keine farben vorhanden sind
     */
    public static Rahmen createRahmen(int id, String hoehen, int form, int reifengroesse, String bild, int beschreibungID, int steuersatz,
                                      int schaftshoehe, int zusatzbefest, boolean scheibenbremse, boolean felgenbremse, int tretlager,
                                      int fromTyp, int formTypID, String name, int preis, boolean gepaektraeger, boolean licht, String farben) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id,beschreibungID,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");
        if(bild == null) throw new ValuesCreateException("Der Parameter 'bild' darf nicht null sein! ");
        if(name == null) throw new ValuesCreateException("Der Parameter 'name' darf nicht null sein! ");

        List<String> farbenListe = createFarbListe(farben);
        List<Integer> hoehenListe = createHoehenListe(hoehen);

        if(farbenListe == null) throw new ValuesCreateException("Der Parameter 'farben' darf nicht null sein! ");
        if(hoehenListe == null) throw new ValuesCreateException("Der Parameter 'hoehen' darf nicht null sein! ");
        if(hoehenListe.isEmpty()) throw new ValuesCreateException("Es muss eine gewisse Anzahl der Hoehen gegeben sein! ");
        if(farbenListe.isEmpty()) throw new ValuesCreateException("Es muss eine gewisse Anzahl der Farben gegeben sein! ");

        return Rahmen.getValue(id,hoehenListe,form,reifengroesse,bild,beschreibungID,steuersatz,schaftshoehe,zusatzbefest,scheibenbremse,
                felgenbremse,tretlager,fromTyp,formTypID,name,preis,gepaektraeger,licht,farbenListe);
    }


    /**
     * Create Sattel
     * Erstellt den DatenTyp Sattel, wobei folgende Bedingungen erfuellt seien muessen:
     * @require id > 0 & beschrID > 0 & formTID > 0
     * @require formTyp >= 0
     *
     * @param id
     * @param name
     * @param beschreibungId
     * @param preis
     * @param formTyp
     * @param formTypID
     * @param bild
     * @return DatenTyp Sattel
     *
     * @throws ValuesCreateException
     *
     *          Wirf eine ValuesCreateException wenn mindestens eine der folgenden Bedigungen eintreffen:
     *
     *          1) Vorbedingungen verletzt
     *          2) name parameter null ist
     *          3) bild parameter null ist
     */
    public static Sattel createSattel(int id, String name, int beschreibungId, int preis, int formTyp, int formTypID, String bild) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id,beschreibungId,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");
        if(bild == null) throw new ValuesCreateException("Der Parameter 'bild' darf nicht null sein! ");
        if(name == null) throw new ValuesCreateException("Der Parameter 'name' darf nicht null sein! ");
        // TODO gemaess Doc erweitern

        return Sattel.getValue(id,name,beschreibungId,preis,formTyp,formTypID,bild);
    }


    /**
     * Create Vorbau
     * Erstellt den DatenTyp Vorbau, wobei folgende Bedingungen erfuellt seien muessen:
     * @require id > 0 & beschrID > 0 & formTID > 0
     * @require schaftsgroesse >= 0 & formTyp >= 0
     *
     * @param id
     * @param beschreibungID
     * @param preis
     * @param schaftsgroesse
     * @param formTyp
     * @param formTypId
     * @param bild
     * @return DatenTyp Vorbau
     *
     * @throws ValuesCreateException
     *
     *          Wirf eine ValuesCreateException wenn mindestens eine der folgenden Bedigungen eintreffen:
     *
     *          1) Vorbedingungen verletzt
     *          2) bild parameter null ist
     */
    public static Vorbau createVorbau(int id, int beschreibungID, int preis, int schaftsgroesse, int formTyp, int formTypId, String bild) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id,beschreibungID,formTypId)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");
        if(bild == null) throw new ValuesCreateException("Der Parameter 'bild' darf nicht null sein! ");
        // TODO gemaess Doc erweitern

        return Vorbau.getValue(id,beschreibungID,preis,schaftsgroesse,formTyp,formTypId,bild);
    }

    /**
     * Create Zubehoer
     * Erstellt den DatenTyp Zubehoer, wobei folgende Bedingungen erfuellt seien muessen:
     * @require id > 0 & beschrID > 0 & formTID > 0
     * @require zusatzbefest >= 0 & formTyp >= 0
     *
     * @param id
     * @param beschreibungID
     * @param preis
     * @param formTyp
     * @param formTypID
     * @param bild
     * @param name
     * @param zusatzBelegt
     * @return DatenTyp Zubehoer
     *
     * @throws ValuesCreateException
     *
     *          Wirf eine ValuesCreateException wenn mindestens eine der folgenden Bedigungen eintreffen:
     *
     *          1) Vorbedingungen verletzt
     *          2) name parameter null ist
     *          3) bild parameter null ist
     */
    public static Zubehoer createZubehoer(int id, int beschreibungID, int preis, int formTyp, int formTypID, String bild, String name, boolean zusatzBelegt) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id,beschreibungID,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");
        if(bild == null) throw new ValuesCreateException("Der Parameter 'bild' darf nicht null sein! ");
        if(name == null) throw new ValuesCreateException("Der Parameter 'name' darf nicht null sein! ");
        // TODO gemaess Doc erweitern

        return Zubehoer.getValue(id,beschreibungID,preis,formTyp,formTypID,bild,name,zusatzBelegt);
    }

    /**
     * Create Gabel
     * Erstellt den DatenTyp Gabel, wobei folgende Bedingungen erfuellt seien muessen:
     * @require id > 0 & beschrID > 0 & formTID > 0
     * @require schaftslaenge >= 0 & steuersatz >= 0 & reifengroesse >= 0
     *
     * @param id
     * @param beschreibungID
     * @param fromTyp
     * @param formTypID
     * @param schaftslaenge
     * @param steuersatz
     * @param reifengroesse
     * @param preis
     * @param felgenbremse
     * @param scheibenbremse
     * @param licht
     * @param bild
     * @param name
     * @return DatenTyp Gabel
     *
     * @throws ValuesCreateException
     *
     *          Wirf eine ValuesCreateException wenn mindestens eine der folgenden Bedigungen eintreffen:
     *
     *          1) Vorbedingungen verletzt
     *          2) name parameter null ist
     *          3) bild parameter null ist
     */
    public static Gabel createGabel(int id, int beschreibungID, int fromTyp, int formTypID, int schaftslaenge, int steuersatz,
                                    int reifengroesse, int preis, boolean felgenbremse, boolean scheibenbremse, boolean licht,
                                    String bild, String name) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id,beschreibungID,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");
        if(bild == null) throw new ValuesCreateException("Der Parameter 'bild' darf nicht null sein! ");
        if(name == null) throw new ValuesCreateException("Der Parameter 'name' darf nicht null sein! ");
        // TODO gemaess Doc erweitern

        return Gabel.getValue(id,beschreibungID,fromTyp,formTypID,schaftslaenge,steuersatz,reifengroesse,preis,
                felgenbremse,scheibenbremse,licht,bild,name);
    }


    /**
     * Create FormTyp
     * Erstellt den DatenTyp FormTyp, wobei folgende Bedingungen erfuellt seien muessen:
     * @require id > 0
     *
     * @param id
     * @param gabel
     * @param felge
     * @param vorbau
     * @param mantel
     * @param rahmen
     * @param teile
     * @param sattel
     * @return DatenTyp FormTyp
     *
     * @throws ValuesCreateException
     *
     *          Wirf eine ValuesCreateException wenn mindestens eine der folgenden Bedigungen eintreffen:
     *
     *          1) Vorbedingungen verletzt
     */
    public static FormTyp createFormTyp(int id, int gabel, int felge, int vorbau, int mantel, int rahmen, int teile, int sattel) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");

        return FormTyp.getValue(id,gabel,felge,vorbau,mantel,rahmen,teile,sattel);
    }


    /**** Private HilfsMethoden ****/
    private static boolean vorbedingungIDs(int ersteID ,int... ids){

        // id's muessen element von Natuerliche-Zahl sein
        for(int id : ids){
            if(id <= 0) return false;
        }

        if(ersteID <= 0){
            return false;
        }else{
            return true;
        }
    }

    private static List<String> createFarbListe(String farben){

        if(farben == null) return null;

        List<String> farbenListe = new ArrayList();
        for(String eineFarbe : farben.split(STRINGSEPERATOR)){

            farbenListe.add(eineFarbe);
        }
        return farbenListe;
    }

    private static List<Integer> createHoehenListe(String hoehen){

        if(hoehen == null) return null;

        List<Integer> hoehenListe = new ArrayList();
        for(String eineHoehe : hoehen.split(STRINGSEPERATOR)){

            try{

                int hoehe = Integer.parseInt(eineHoehe);
                hoehenListe.add(hoehe);
            }catch (NumberFormatException ex){

            }
        }
        return hoehenListe;
    }
}