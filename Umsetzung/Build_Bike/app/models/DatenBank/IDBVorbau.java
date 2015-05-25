package models.DatenBank;

import models.Exception.DatabaseException;
import models.TeileKomponente.Einzelteile.Beschreibung;
import models.TeileKomponente.Einzelteile.FormTyp;
import models.TeileKomponente.Einzelteile.Vorbau;

import java.util.List;

/**
 * Created by tin on 13.05.15.
 */
public interface IDBVorbau extends ITeileTabellen {

    /**
     * Methode zum erhalten eines Vorbaus
     * @param id id des Vorbaus
     * @return Den Vorbau als List<String>
     */
    public Vorbau getVorbauByID(int id) throws DatabaseException;

    /**
     * Methode zum auslesen aller Vorbäue
      * @return Alle Vorbäue als List<List<String>>
     */
    public List<Vorbau> getAllVorbau() throws DatabaseException;

    /**
     * Methode zum auslesen der Vorbäue mit einen bestimmte Formtyp
     * @param formTyp Formtyp der Vorbäue
     * @return Eine Liste aller Vorbäue mit den gegebenen Formtyp
     */
    public List<Vorbau> getVorbauByFormTyp(int formTyp) throws DatabaseException;

    /**
     * Methode zum auslesen der FormtypTabelle eines Vorbaus
     * @param id ID des Vorbaus
     * @return Tabelle des Formtypes des Vorbaus
     */
    public FormTyp getFormTypTabelleByVorbauID(int id) throws DatabaseException;


    /**
     * Methode zum auslesen der Beschreibung eines Vorbaus
     * @param id ID des Vorbaus
     * @return Eine Liste der Beschreibungen des Vorbaus
     */
    public Beschreibung getBeschreibungByVorbauID(int id) throws DatabaseException;
}
