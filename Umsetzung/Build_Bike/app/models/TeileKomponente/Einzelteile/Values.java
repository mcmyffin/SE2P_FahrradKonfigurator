package models.TeileKomponente.Einzelteile;

import models.TeileKomponente.Einzelteile.*;

/**
 * Created by dima on 24.05.15.
 */
public class Values {


    public static Felge createFelge(int id, int beschrID, int preis, int reifGr, int formT, int formTID, String bild, String name, boolean narbendynamo){
        return Felge.getValue(id,beschrID,preis,reifGr,formT,formTID,bild,name,narbendynamo);
    }

    public  static Mantel createMantel(int id, int beschreibungID, int formTyp, int formTypID, int durchmesser, int reifengroesse, int preis, String bild, String name){
        return null;
    }

    public static Rahmen createRahmen(int id, int hoehe, int form, int reifengroesse, String bild, int beschreibungID, int steuersatz,
                                      int schaftshoehe, int zusatzbefest, boolean scheibenbremse, boolean felgenbremse, int tretlager,
                                      int fromTyp, int formTypID, String name, int preis, boolean gepaektraeger, boolean licht){
        return null;
    }

    public static Sattel createSattel(int id, int name, int beschreibungId, int preis, int formTyp, int formTypID, String bild){

        return null;
    }

    public static Vorbau createVorbau(int id, int beschreibungID, int preis, int schaftsgroesse, int formTyp, int formTypId, String bild){
        return null;
    }

    public static Zubehoer createZubehoer(int id, int beschreibungID, int preis, int formTyp, int formTypID, String bild, String name, boolean zusatzBelegt){
        return null;
    }
}
