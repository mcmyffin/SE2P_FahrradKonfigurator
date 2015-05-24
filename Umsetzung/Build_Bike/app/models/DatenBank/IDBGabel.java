package models.DatenBank;

import models.Exception.DatabaseException;

import java.util.List;

/**
 * Created by tin on 13.05.15.
 */
public interface IDBGabel extends ITeileTabellen {

    /**
     * Methode zum erhalten einer Gabel
     * @param id id der Gabel
     * @return Die Gabel als List<String>
     */
    public List<String> getGabelnByID(int id) throws DatabaseException;

    /**
     * Methode zum auslesen aller Gabeln
     * @return Alle Gabeln als List<List<String>>
     */
    public List<List<String>> getAllGabel() throws DatabaseException;

    /**
     * Methode zum auslesen der Gabeln mit einen bestimmte Formtyp
     * @param formTyp Formtyp der Gabeln
     * @return Eine Liste aller Gabeln mit den gegebenen Formtyp
     */
    public List<List<String>> getGabelByFormTyp(int formTyp) throws DatabaseException;

    /**
     * Methode zum auslesen der FormtypTabelle einer Gabel
     * @param id ID der Gabel
     * @return Tabelle des Formtypes der Gabel
     */
    public List<Integer> getFormTypTabelleByGabelID(int id) throws DatabaseException;


    /**
     * Methode zum auslesen der Beschreibung einer Gabel
     * @param id ID der Gabel
     * @return Eine Liste der Beschreibungen der Gabel
     */
    public List<String> getBeschreibungByGabelID(int id) throws DatabaseException;
}