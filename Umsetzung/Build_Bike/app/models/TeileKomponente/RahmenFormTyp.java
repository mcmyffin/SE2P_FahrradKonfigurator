package models.TeileKomponente;

import models.Exception.RahmenFormTypException;

/**
 * Created by dima on 24.05.15.
 */
public enum RahmenFormTyp {

    HERREN_FORM(0),
    DAMEN_FORM(1),
    SPORT_FORM(2);

    private int value;

    RahmenFormTyp(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public RahmenFormTyp getFormTypByInt(int value) throws RahmenFormTypException {

        if(HERREN_FORM.getValue() == value) return HERREN_FORM;
        if(DAMEN_FORM.getValue() == value)  return DAMEN_FORM;
        if(SPORT_FORM.getValue() == value)  return SPORT_FORM;
        else throw new RahmenFormTypException("Kein RahmenTyp konnte anhand '"+value+"' indentifiziert werden");
    }
}
