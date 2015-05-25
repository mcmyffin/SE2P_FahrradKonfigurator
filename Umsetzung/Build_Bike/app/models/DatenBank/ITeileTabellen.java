package models.DatenBank;

import models.Exception.DatabaseException;
import models.TeileKomponente.Einzelteile.Beschreibung;
import models.TeileKomponente.Einzelteile.FormTyp;

import java.util.List;

/**
 * Created by tin on 13.05.15.
 */
public interface ITeileTabellen {


    /**
     * Methode zum erhalten einer Beschreibung.
     * @param id id der Beschreibung
     * @return die Beschreibung als List<String>
     */
    public Beschreibung getBeschreibungByID(int id) throws DatabaseException;


    /**
     * Methode zum erhalten einer FormTyp-Tabelle
     * @param id id des FormTyps
     * @return Die FormTyp-Tabelle als List<Integer>
     */
    public FormTyp getFormTypTabelleByID(int id) throws DatabaseException;

}
