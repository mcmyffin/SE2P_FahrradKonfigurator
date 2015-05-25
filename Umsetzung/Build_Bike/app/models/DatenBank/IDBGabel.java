package models.DatenBank;

import models.Exception.DatabaseException;
import models.TeileKomponente.Einzelteile.Beschreibung;
import models.TeileKomponente.Einzelteile.FormTyp;
import models.TeileKomponente.Einzelteile.Gabel;

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
    public Gabel getGabelnByID(int id) throws DatabaseException;

    /**
     * Methode zum auslesen aller Gabeln
     * @return Alle Gabeln als List<List<String>>
     */
    public List<Gabel> getAllGabel() throws DatabaseException;

    /**
     * Methode zum auslesen der Gabeln mit einen bestimmte Formtyp
     * @param formTyp Formtyp der Gabeln
     * @return Eine Liste aller Gabeln mit den gegebenen Formtyp
     */
    public List<Gabel> getGabelByFormTyp(int formTyp) throws DatabaseException;

    /**
     * Methode zum auslesen der FormtypTabelle einer Gabel
     * @param id ID der Gabel
     * @return Tabelle des Formtypes der Gabel
     */
    public FormTyp getFormTypTabelleByGabelID(int id) throws DatabaseException;


    /**
     * Methode zum auslesen der Beschreibung einer Gabel
     * @param id ID der Gabel
     * @return Eine Liste der Beschreibungen der Gabel
     */
    public Beschreibung getBeschreibungByGabelID(int id) throws DatabaseException;
}
