package models.TeileKomponente;

import models.DatenBank.DataC;
import models.DatenBank.IDBAlleTeile;
import models.DatenBank.ITeileTabellen;
import models.DatenTypen.Pair;
import models.Exception.DatabaseException;
import models.TeileKomponente.DTO.EinzelteilDTO;
import models.TeileKomponente.Einzelteile.*;

import java.util.List;

/**
 * Created by dima on 19.05.15.
 */
public class TeileKomponente implements ITeileKomponente{


    private final int LIST_LENGTH = 2;
    private ITeileTabellen teilePersistenz = new DataC();
    private IDBAlleTeile alleTeilePersistenz = new DataC();



    @Override
    public EinzelteilDTO toEinzelteilDTO(Felge felge) {

        // precondition fuer null Objekte
        if(felge == null) return null;

        Beschreibung beschreibung = getBeschreibungen(felge.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                felge.getId(),
                felge.getPreis(),
                felge.getName(),
                beschreibung.getKurzbeschreibung(),
                beschreibung.getWerbetext(),
                felge.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Gabel gabel) {

        // precondition fuer null Objekte
        if(gabel == null) return null;

        Beschreibung beschreibung = getBeschreibungen(gabel.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                gabel.getId(),
                gabel.getPreis(),
                gabel.getName(),
                beschreibung.getKurzbeschreibung(),
                beschreibung.getWerbetext(),
                gabel.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Mantel mantel) {

        // precondition fuer null Objekte
        if(mantel == null) return null;

        Beschreibung beschreibung = getBeschreibungen(mantel.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                mantel.getId(),
                mantel.getPreis(),
                mantel.getName(),
                beschreibung.getKurzbeschreibung(),
                beschreibung.getWerbetext(),
                mantel.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Rahmen rahmen) {

        // precondition fuer null Objekte
        if(rahmen== null) return null;

        Beschreibung beschreibung = getBeschreibungen(rahmen.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                rahmen.getId(),
                rahmen.getPreis(),
                rahmen.getName(),
                beschreibung.getKurzbeschreibung(),
                beschreibung.getWerbetext(),
                rahmen.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Sattel sattel) {

        // precondition fuer null Objekte
        if(sattel == null) return null;

        Beschreibung beschreibung = getBeschreibungen(sattel.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                sattel.getId(),
                sattel.getPreis(),
                sattel.getName(),
                beschreibung.getKurzbeschreibung(),
                beschreibung.getWerbetext(),
                sattel.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Vorbau vorbau) {

        // precondition fuer null Objekte
        if(vorbau == null) return null;

        Beschreibung beschreibung = getBeschreibungen(vorbau.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                vorbau.getId(),
                vorbau.getPreis(),
                "",
                beschreibung.getKurzbeschreibung(),
                beschreibung.getWerbetext(),
                vorbau.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Zubehoer zubehoer) {

        // precondition fuer null Objekte
        if(zubehoer == null) return null;

        Beschreibung beschreibung = getBeschreibungen(zubehoer.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                zubehoer.getId(),
                zubehoer.getPreis(),
                zubehoer.getName(),
                beschreibung.getKurzbeschreibung(),
                beschreibung.getWerbetext(),
                zubehoer.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }


    @Override
    public List<Felge> getFelgeList() {
        try {
            return alleTeilePersistenz.getAllFelgen();
        } catch (DatabaseException e) {
            return null;
        }
    }

    @Override
    public List<Gabel> getGabelList() {

        try {
            return alleTeilePersistenz.getAllGabel();
        } catch (DatabaseException e) {
            return null;
        }
    }

    @Override
    public List<Mantel> getMaentelList() {
        try {
            return alleTeilePersistenz.getAllMantel();
        } catch (DatabaseException e) {
            return null;
        }
    }

    @Override
    public List<Rahmen> getRahmenList() {
        try {
            return alleTeilePersistenz.getAllRahmen();
        } catch (DatabaseException e) {
            return null;
        }
    }

    @Override
    public List<Sattel> getSattelList() {
        try {
            return alleTeilePersistenz.getAllSattel();
        } catch (DatabaseException e) {
            return null;
        }
    }

    @Override
    public List<Vorbau> getVorbauList() {
        return alleTeilePersistenz.getAllVorbau();
    }

    @Override
    public List<Zubehoer> getZubehoerList() {
        try {
            return alleTeilePersistenz.getAllTeile();
        } catch (DatabaseException e) {
            return null;
        }
    }


    /*** private Hilfsmethoden ***/

    // Erstellt ein Paar mit Beschreibungen.
    // Key = Kurzbeschreibung
    // Value = Werbetext
    private Beschreibung getBeschreibungen(int beschrID){

        return alleTeilePersistenz.getBeschreibungByID(beschrID);
    }
}

