package models.TeileKomponente.Einzelteile;

import models.DatenTypen.Pair;

/**
 * Created by dima on 25.05.15.
 */
public class Beschreibung {

    private Pair<String,String> beschreibungsPaar;

    public Beschreibung(String kurzbeschreibung, String werbetext){
        if(kurzbeschreibung == null) throw new NullPointerException("Kurzbeschreibung darf nicht null sein !");
        if(werbetext== null) throw new NullPointerException("Werbetext darf nicht null sein !");

        beschreibungsPaar = new Pair<String,String>(kurzbeschreibung,werbetext);
    }

    public String getKurzbeschreibung(){
        return beschreibungsPaar.getKey();
    }

    public String getWerbetext(){
        return beschreibungsPaar.getValue();
    }
}
