package models.TeileKomponente;

import models.Exception.EinzelteileTypException;

/**
 * Created by dima on 24.05.15.
 */
public enum EinzelTeileTyp {

    RAHMEN("Rahmen"),
    FELGE("Felge"),
    MANTEL("Mantel"),
    SATTEL("Sattel"),
    VORBAU("Vorbau"),
    GABEL("Gabel"),
    ZUBEHOER("Zubehoer");

    private String value;

    EinzelTeileTyp(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static EinzelTeileTyp getEinzelteileTypByString(String value) throws EinzelteileTypException{

        if(RAHMEN.getValue().equals(value))     return RAHMEN;
        if(FELGE.getValue().equals(value))      return FELGE;
        if(MANTEL.getValue().equals(value))     return MANTEL;
        if(SATTEL.getValue().equals(value))     return SATTEL;
        if(VORBAU.getValue().equals(value))     return VORBAU;
        if(GABEL.getValue().equals(value))      return GABEL;
        if(ZUBEHOER.getValue().equals(value))   return ZUBEHOER;
        else throw new EinzelteileTypException("Die Eingabe '"+value+"' passt mit keinem Einzelteil ueberein");
    }
}
