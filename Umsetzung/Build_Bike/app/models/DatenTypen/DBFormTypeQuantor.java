package models.DatenTypen;

import models.Exception.DBFormTypeQuantorException;

/**
 * Created by dima on 25.05.15.
 */
public enum DBFormTypeQuantor {

    ALL(0),
    NOT_ALL(-1);

    private int value;

    private DBFormTypeQuantor(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static DBFormTypeQuantor getFormTypeQuantorByInt(int value) throws DBFormTypeQuantorException {
        if(ALL.getValue() == value) return ALL;
        if(NOT_ALL.getValue() == value) return NOT_ALL;
        else throw new DBFormTypeQuantorException("Die Eingabe '"+value+"' konnte keinem Quantor zugeordnet werden");
    }
}
