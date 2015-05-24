package models.DatenBank;

import models.Exception.DatabaseException;

import java.util.List;

/**
 * Created by tin on 13.05.15.
 */
public interface IDBTeile extends ITeileTabellen {

    /**
     * Methode zum erhalten eines Teils
     * @param id id des Teils
     * @return Den Teil als List<String>
     */
    public List<String> getTeileByID(int id) throws DatabaseException;

    /**
     * Methode zum auslesen aller Teile
     * @return Alle Teile als List<List<String>>
     */
    public List<List<String>> getAllTeile() throws DatabaseException;

    /**
     * Methode zum auslesen der Teile mit einen bestimmte Formtyp
     * @param formTyp Formtyp der Teile
     * @return Eine Liste aller Teile mit den gegebenen Formtyp
     */
    public List<List<String>> getTeileByFormTyp(int formTyp) throws DatabaseException;

    /**
     * Methode zum auslesen der FormtypTabelle eines Teils
     * @param id ID des Teils
     * @return Tabelle des Formtypes des Teils
     */
    public List<Integer> getFormTypTabelleByTeileID(int id) throws DatabaseException;


    /**
     * Methode zum auslesen der Beschreibung eines Vorbaus
     * @param id ID des Teils
     * @return Eine Liste der Beschreibungen des Teils
     */
    public List<String> getBeschreibungByTeileID(int id) throws DatabaseException;
}
