package models.DatenBank;

import models.Exception.DatabaseException;

import java.util.List;

/**
 * Created by tin on 13.05.15.
 */
public interface IDBRahmen extends ITeileTabellen {

    /**
     * Methode zum auslesen der Rahmen aus der Datenbank
     * @param formTyp Form-Typ der Rahmen, die man erhaltne möchte
     * @return Eigenschaftne der Rahmen
     */
    public List<List<String>> getRahmenByFormtyp(int formTyp) throws DatabaseException;


    /**
     * Methode zum Auslesen eines bestimmten Rahmens
     * @param rID ID des Rahmens
     * @return Eigenschaften des Rahmens
     */
    public List<String> getRahmenByID(int rID) throws DatabaseException;

    /**
     * Methode zum Auslesen von der Bschriebung eines Rahmens
     * @param rID ID des Rahmens
     * @return Beschreibung des Rahmens
     */
    public List<String> getBeschreibungByRahmenID(int rID) throws DatabaseException;

    /**
     * Methode zum auslesen der FormTypTabelle mittels der Rahmen ID
     * @param id ID des Rahmens
     * @return FormTypTabelle des Rahmens
     */
    public List<Integer> getFormTypTabelleByRahmenID(int id) throws DatabaseException;

    /**
     * Methode zum auslesen ALLER Rahmen aus der Datenbank
     * @return Alle rahmen der Datenbank
     */
    public List<List<String>> getAllRahmen() throws DatabaseException;
}
