package models.DatenBank;

import models.Exception.DatabaseException;
import models.TeileKomponente.Einzelteile.Sattel;

import java.util.List;

/**
 * Created by tin on 13.05.15.
 */
public interface IDBSattel extends ITeileTabellen {

    /**
     * Methode zum erhalten eines Sattels
     * @param id id des Sattels
     * @return Den Sattel als List<String>
     */
    public Sattel getSattelByID(int id) throws DatabaseException;

    /**
     * Methode zum auslesen aller Sättel
     * @return Alle Sättel als List<List<String>>
     */
    public List<Sattel> getAllSattel() throws DatabaseException;

    /**
     * Methode zum auslesen der Sättel mit einen bestimmte Formtyp
     * @param formTyp Formtyp der Sättel
     * @return Eine Liste aller Sättel mit den gegebenen Formtyp
     */
    public List<Sattel> getSattelByFormTyp(int formTyp) throws DatabaseException;

    /**
     * Methode zum auslesen der FormtypTabelle eines Sattels
     * @param id ID des Sattels
     * @return Tabelle des Formtypes des Sattels
     */
    public List<Integer> getFormTypTabelleBySattelID(int id) throws DatabaseException;


    /**
     * Methode zum auslesen der Beschreibung eines Sattels
     * @param id ID des Sattels
     * @return Eine Liste der Beschreibungen des Sattels
     */
    public List<String> getBeschreibungBySattelID(int id) throws DatabaseException;
}
