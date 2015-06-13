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
                felge.getEinzelTeileTyp().getValue(),
                felge.getBild()
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
                gabel.getEinzelTeileTyp().getValue(),
                gabel.getBild()
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
                mantel.getEinzelTeileTyp().getValue(),
                mantel.getBild()
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
                rahmen.getEinzelTeileTyp().getValue(),
                rahmen.getBild()
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
                sattel.getEinzelTeileTyp().getValue(),
                sattel.getBild()
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
                vorbau.getEinzelTeileTyp().getValue(),
                vorbau.getBild()
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
                zubehoer.getEinzelTeileTyp().getValue(),
                zubehoer.getBild()
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

        try {
            return alleTeilePersistenz.getAllVorbau();
        } catch (DatabaseException e) {
            return null;
        }
    }

    @Override
    public List<Zubehoer> getZubehoerList() {
        try {
            return alleTeilePersistenz.getAllTeile();
        } catch (DatabaseException e) {
            return null;
        }
    }

    @Override
    public Felge getFelgeByID(int id) {

        Felge felge = null;

        try {
            felge = alleTeilePersistenz.getFelgeByID(id);
        } catch (DatabaseException e) {
            return felge;
        }
        return felge;
    }

    @Override
    public Gabel getGabelByID(int id) {
        Gabel gabel = null;

        try {
            gabel = alleTeilePersistenz.getGabelnByID(id);
        } catch (DatabaseException e) {
            return gabel;
        }
        return gabel;
    }

    @Override
    public Mantel getMantelByID(int id) {

        Mantel mantel = null;

        try {
            mantel = alleTeilePersistenz.getMantelByID(id);
        } catch (DatabaseException e) {
            return mantel;
        }
        return mantel;
    }

    @Override
    public Rahmen getRahmenByID(int id) {

        Rahmen rahmen = null;

        try {
            rahmen = alleTeilePersistenz.getRahmenByID(id);
        } catch (DatabaseException e) {
            return rahmen;
        }
        return rahmen;
    }

    @Override
    public Sattel getSattelByID(int id) {

        Sattel sattel = null;

        try {
            sattel = alleTeilePersistenz.getSattelByID(id);
        } catch (DatabaseException e) {
            return sattel;
        }
        return sattel;
    }

    @Override
    public Vorbau getVorbauByID(int id) {

        Vorbau vorbau = null;

        try {
            vorbau = alleTeilePersistenz.getVorbauByID(id);
        } catch (DatabaseException e) {
            return vorbau;
        }
        return vorbau;
    }

    @Override
    public Zubehoer getZubehoerByID(int id) {

        Zubehoer zubehoer = null;

        try {
            zubehoer = alleTeilePersistenz.getTeileByID(id);
        } catch (DatabaseException e) {
            return zubehoer;
        }
        return zubehoer;
    }


    /*** private Hilfsmethoden ***/

    // Erstellt ein Paar mit Beschreibungen.
    // Key = Kurzbeschreibung
    // Value = Werbetext
    private Beschreibung getBeschreibungen(int beschrID){

        try {
            return alleTeilePersistenz.getBeschreibungByID(beschrID);
        } catch (DatabaseException e) {
            return null;
        }
    }
}

