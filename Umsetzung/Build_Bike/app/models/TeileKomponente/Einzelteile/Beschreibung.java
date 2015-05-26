package models.TeileKomponente.Einzelteile;

import models.DatenTypen.Pair;

/**
 * Created by dima on 25.05.15.
 */
public class Beschreibung {

    private Pair<String,String> beschreibungsPaar;

    /**
     *
     * @param kurzbeschreibung
     * @param werbetext
     */
    public Beschreibung(String kurzbeschreibung, String werbetext){
        if(kurzbeschreibung == null) throw new NullPointerException("Kurzbeschreibung darf nicht null sein !");
        if(werbetext== null) throw new NullPointerException("Werbetext darf nicht null sein !");

        beschreibungsPaar = new Pair<String,String>(kurzbeschreibung,werbetext);
    }

    /**
     * Get Kurzbeschreibung
     * Gibt die Kurzbeschreibung aus
     *
     * @return kurzbeschreibung
     */
    public String getKurzbeschreibung(){
        return beschreibungsPaar.getKey();
    }

    /**
     * Get Werbetext
     * Gibt den Werbetext aus
     *
     * @return werbetext
     */
    public String getWerbetext(){
        return beschreibungsPaar.getValue();
    }
}
