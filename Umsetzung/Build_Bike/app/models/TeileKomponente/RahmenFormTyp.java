package models.TeileKomponente;

import models.DatenTypen.Pair;
import models.Exception.RahmenFormTypException;

/**
 * Created by dima on 25.05.15.
 */
public enum RahmenFormTyp {

    CITTY_BIKE(0,"City Bike"),
    MOUNTEN_BIKE(1, "Mounten Bike"),
    TRAKKING_BIKE(2, "Trekking Bike");

    private int nummer;
    private String bezeichnung;

    private RahmenFormTyp(int nummer, String bezeichnung){
        this.nummer = nummer;
        this.bezeichnung = bezeichnung;
    }

    public int getNummer(){
        return this.nummer;
    }

    public String getBezeichnung(){
        return this.bezeichnung;
    }

    /**
     * Get Rahmenformtyp by Int
     * Versucht die Eingabe zu einem RahmenFormTyp zu parsen.
     *
     * @param nummer (int)
     * @return RahmenFormTyp wenn erfolgreich geparst.
     * @throws RahmenFormTypException wenn:
     *      Eingabe = null oder
     *      Eingabe der Rahmenform nicht zugeordnet werden kann.
     */
    public static RahmenFormTyp getRahmenFormTypByInt(int nummer) throws RahmenFormTypException {

        if(CITTY_BIKE.getNummer() == nummer)    return CITTY_BIKE;
        if(MOUNTEN_BIKE.getNummer() == nummer)  return MOUNTEN_BIKE;
        if(TRAKKING_BIKE.getNummer() == nummer) return TRAKKING_BIKE;
        else throw new RahmenFormTypException("Kein RahmenFormTyp konnte der Nummer '"+nummer+"' zugeordnet werden. ");
    }

    /**
     * Get Rahmenformtyp by String
     * Versucht die Eingabe zu einem RahmenFormTyp zu parsen.
     *
     * @param bezeichnung (String)
     * @return RahmenFormTyp wenn erfolgreich geparst.
     * @throws RahmenFormTypException wenn:
     *      Eingabe = null oder
     *      Eingabe der Rahmenform nicht zugeordnet werden kann.
     */
    public static RahmenFormTyp getRahmenFormTypByString(String bezeichnung) throws RahmenFormTypException{

        // preconditions
        if(bezeichnung == null) throw new RahmenFormTypException("Bezeichnung darf nicht null sein !");

        if(CITTY_BIKE.getBezeichnung().equals(bezeichnung))     return CITTY_BIKE;
        if(MOUNTEN_BIKE.getBezeichnung().equals(bezeichnung))   return MOUNTEN_BIKE;
        if(TRAKKING_BIKE.getBezeichnung().equals(bezeichnung))  return TRAKKING_BIKE;
        else throw new RahmenFormTypException("Kein RahmenFormTyp konnte der Bezeichnung '"+bezeichnung+"' zugeordnet werden. ");
    }
}
