package models.DatenBank;

import models.Exception.DatabaseException;
import models.TeileKomponente.Einzelteile.Beschreibung;
import models.TeileKomponente.Einzelteile.FormTyp;
import models.TeileKomponente.Einzelteile.Rahmen;

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
    public List<Rahmen> getRahmenByFormtyp(int formTyp) throws DatabaseException;


    /**
     * Methode zum Auslesen eines bestimmten Rahmens
     * @param rID ID des Rahmens
     * @return Eigenschaften des Rahmens
     */
    public Rahmen getRahmenByID(int rID) throws DatabaseException;

    /**
     * Methode zum Auslesen von der Bschriebung eines Rahmens
     * @param rID ID des Rahmens
     * @return Beschreibung des Rahmens
     */
    public Beschreibung getBeschreibungByRahmenID(int rID) throws DatabaseException;

    /**
     * Methode zum auslesen der FormTypTabelle mittels der Rahmen ID
     * @param id ID des Rahmens
     * @return FormTypTabelle des Rahmens
     */
    public FormTyp getFormTypTabelleByRahmenID(int id) throws DatabaseException;

    /**
     * Methode zum auslesen ALLER Rahmen aus der Datenbank
     * @return Alle rahmen der Datenbank
     */
    public List<Rahmen> getAllRahmen() throws DatabaseException;
}
