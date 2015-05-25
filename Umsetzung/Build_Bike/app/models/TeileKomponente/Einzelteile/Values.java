package models.TeileKomponente.Einzelteile;

import models.Exception.ValuesCreateException;
import models.TeileKomponente.Einzelteile.*;

/**
 * Created by dima on 24.05.15.
 */
public class Values {


    public static Felge createFelge(int id, int beschrID, int preis, int reifGr, int formT, int formTID, String bild, String name, boolean narbendynamo) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id,beschrID,formTID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");

        // TODO mehr ausfuehrliche Uberpruefung

        return Felge.getValue(id,beschrID,preis,reifGr,formT,formTID,bild,name,narbendynamo);
    }

    public  static Mantel createMantel(int id, int beschreibungID, int formTyp, int formTypID, int durchmesser, int reifengroesse, int preis, String bild, String name) throws ValuesCreateException {

        // Vorbedingungen
        if(!vorbedingungIDs(id,beschreibungID,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");

        // TODO mehr ausfuehrliche Uberpruefung

        return Mantel.getValue(id,beschreibungID,formTyp,formTypID,durchmesser,reifengroesse,preis,bild,name);
    }

    public static Rahmen createRahmen(int id, int hoehe, int form, int reifengroesse, String bild, int beschreibungID, int steuersatz,
                                      int schaftshoehe, int zusatzbefest, boolean scheibenbremse, boolean felgenbremse, int tretlager,
                                      int fromTyp, int formTypID, String name, int preis, boolean gepaektraeger, boolean licht) throws ValuesCreateException {

        if(!vorbedingungIDs(id,beschreibungID,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");

        // TODO mehr ausfuehrliche Uberpruefung

        return Rahmen.getValue(id,hoehe,form,reifengroesse,bild,beschreibungID,steuersatz,schaftshoehe,zusatzbefest,scheibenbremse,
                felgenbremse,tretlager,fromTyp,formTypID,name,preis,gepaektraeger,licht);
    }

    public static Sattel createSattel(int id, String name, int beschreibungId, int preis, int formTyp, int formTypID, String bild) throws ValuesCreateException {

        if(!vorbedingungIDs(id,beschreibungId,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");

        // TODO mehr ausfuehrliche Uberpruefung

        return Sattel.getValue(id,name,beschreibungId,preis,formTyp,formTypID,bild);
    }

    public static Vorbau createVorbau(int id, int beschreibungID, int preis, int schaftsgroesse, int formTyp, int formTypId, String bild) throws ValuesCreateException {

        if(!vorbedingungIDs(id,beschreibungID,formTypId)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");

        // TODO mehr ausfuehrliche Uberpruefung

        return Vorbau.getValue(id,beschreibungID,preis,schaftsgroesse,formTyp,formTypId,bild);
    }

    public static Zubehoer createZubehoer(int id, int beschreibungID, int preis, int formTyp, int formTypID, String bild, String name, boolean zusatzBelegt) throws ValuesCreateException {

        if(!vorbedingungIDs(id,beschreibungID,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");

        // TODO mehr ausfuehrliche Uberpruefung

        return Zubehoer.getValue(id,beschreibungID,preis,formTyp,formTypID,bild,name,zusatzBelegt);
    }

    public static Gabel createGabel(int id, int beschreibungID, int fromTyp, int formTypID, int schaftslaenge, int steuersatz,
                                    int reifengroesse, int preis, boolean felgenbremse, boolean scheibenbremse, boolean licht,
                                    String bild, String name) throws ValuesCreateException {

        if(!vorbedingungIDs(id,beschreibungID,formTypID)) throw new ValuesCreateException("Ungueltige ID parameter gefunden");

        // TODO mehr ausfuehrliche Uberpruefung

        return Gabel.getValue(id,beschreibungID,fromTyp,formTypID,schaftslaenge,steuersatz,reifengroesse,preis,
                felgenbremse,scheibenbremse,licht,bild,name);
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
}