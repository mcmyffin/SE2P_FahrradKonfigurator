package models.TeileKomponente;

import models.DatenBank.DataC;
import models.DatenBank.ITeileTabellen;
import models.Exception.DatabaseException;
import models.TeileKomponente.DTO.EinzelteilDTO;
import models.TeileKomponente.Einzelteile.*;

import java.util.List;

/**
 * Created by dima on 19.05.15.
 */
public class TeileKomponente implements ITeileKomponente{

    ITeileTabellen teilePersistenz = new DataC();



    @Override
    public EinzelteilDTO toEinzelteilDTO(Felge felge) {

        List<String> beschreibungen= null;
        EinzelteilDTO einzelteilDTO = null;

        try {
            beschreibungen = teilePersistenz.getBeschreibungByID(felge.getBeschreibungID());
        } catch (DatabaseException e) {
            return null;
        }

        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Gabel gabel) {
        return null;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Mantel mantel) {
        return null;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Rahmen rahmen) {
        return null;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Sattel sattel) {
        return null;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Vorbau vorbau) {
        return null;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Zubehoer zubehoer) {
        return null;
    }
}
