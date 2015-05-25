package models.DatenBank;

import models.Exception.DatabaseException;
import models.TeileKomponente.Einzelteile.Beschreibung;
import models.TeileKomponente.Einzelteile.FormTyp;
import models.TeileKomponente.Einzelteile.Mantel;

import java.util.List;

/**
 * Created by tin on 13.05.15.
 */
public interface IDBMantel extends ITeileTabellen {

    /**
     * Methode zum erhalten eines Mantels
     * @param id id des Mantels
     * @return Den Mantels als List<String>
     */
    public Mantel getMantelByID(int id) throws DatabaseException;

    /**
     * Methode zum auslesen aller Mäntel
     * @return Alle Mäntel als List<List<String>>
     */
    public List<Mantel> getAllMantel() throws DatabaseException;

    /**
     * Methode zum auslesen der Mäntel mit einen bestimmte Formtyp
     * @param formTyp Formtyp der Mäntel
     * @return Eine Liste aller Mäntel mit den gegebenen Formtyp
     */
    public List<Mantel> getMantelByFormTyp(int formTyp) throws DatabaseException;

    /**
     * Methode zum auslesen der FormtypTabelle eines Mantels
     * @param id ID des Mantels
     * @return Tabelle des Formtypes des Mantels
     */
    public FormTyp getFormTypTabelleByMantelID(int id) throws DatabaseException;


    /**
     * Methode zum auslesen der Beschreibung eines Mantels
     * @param id ID des Mantels
     * @return Eine Liste der Beschreibungen des Mantels
     */
    public Beschreibung getBeschreibungByMantelID(int id) throws DatabaseException;
}
