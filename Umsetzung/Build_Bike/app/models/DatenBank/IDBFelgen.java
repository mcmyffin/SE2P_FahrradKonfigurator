package models.DatenBank;

import models.Exception.DatabaseException;
import models.TeileKomponente.Einzelteile.Felge;

import java.util.List;

/**
 * Created by tin on 13.05.15.
 */
public interface IDBFelgen extends ITeileTabellen {

    /**
     * Methode zum erhalten einer Felge
     * @param id id der Felge
     * @return Die Felge als List<String>
     */
    public Felge getFelgeByID(int id) throws DatabaseException;

    /**
     * Methode zum auslesen aller Felgen
     * @return Alle Felgen als List<List<String>>
     */
    public List<Felge> getAllFelgen() throws DatabaseException;

    /**
     * Methode zum auslesen der Felgen mit einen bestimmte Formtyp
     * @param formTyp Formtyp der Felgen
     * @return Eine Liste aller Felgen mit den gegebenen Formtyp
     */
    public List<Felge> getFelgeByFormTyp(int formTyp) throws DatabaseException;

    /**
     * Methode zum auslesen der FormtypTabelle einer Flge
     * @param id ID der Felge
     * @return Tabelle des Formtypes der Felge
     */
    public List<Integer> getFormTypTabelleByFelgeID(int id) throws DatabaseException;


    /**
     * Methode zum auslesen der Beschreibung einer Felge
     * @param id ID der Felge
     * @return Eine Liste der Beschreibungen der Felge
     */
    public List<String> getBeschreibungByFelgeID(int id) throws DatabaseException;
}
