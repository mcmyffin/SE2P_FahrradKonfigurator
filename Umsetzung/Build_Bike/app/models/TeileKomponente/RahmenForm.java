package models.TeileKomponente;

import models.Exception.RahmenFormException;

/**
 * Created by dima on 24.05.15.
 */
public enum RahmenForm {

    HERREN_FORM(0),
    DAMEN_FORM(1),
    TRAPETZ_FORM(2);

    private int value;

    RahmenForm(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public RahmenForm getFormTypByInt(int value) throws RahmenFormException {

        if(HERREN_FORM.getValue() == value) return HERREN_FORM;
        if(DAMEN_FORM.getValue() == value)  return DAMEN_FORM;
        if(TRAPETZ_FORM.getValue() == value)  return TRAPETZ_FORM;
        else throw new RahmenFormException("Kein RahmenTyp konnte anhand '"+value+"' indentifiziert werden");
    }
}
