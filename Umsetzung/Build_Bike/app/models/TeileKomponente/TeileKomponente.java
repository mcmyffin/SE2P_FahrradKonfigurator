package models.TeileKomponente;

import models.DatenBank.DataC;
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



    @Override
    public EinzelteilDTO toEinzelteilDTO(Felge felge) {

        // precondition fuer null Objekte
        if(felge == null) return null;

        Pair<String,String> beschreibungsPaar = getBeschreibungen(felge.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                felge.getId(),
                felge.getPreis(),
                felge.getName(),
                beschreibungsPaar.getKey(),
                beschreibungsPaar.getValue(),
                felge.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Gabel gabel) {

        // precondition fuer null Objekte
        if(gabel == null) return null;

        Pair<String,String> beschreibungsPaar = getBeschreibungen(gabel.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                gabel.getId(),
                gabel.getPreis(),
                gabel.getName(),
                beschreibungsPaar.getKey(),
                beschreibungsPaar.getValue(),
                gabel.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Mantel mantel) {

        // precondition fuer null Objekte
        if(mantel == null) return null;

        Pair<String,String> beschreibungsPaar = getBeschreibungen(mantel.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                mantel.getId(),
                mantel.getPreis(),
                mantel.getName(),
                beschreibungsPaar.getKey(),
                beschreibungsPaar.getValue(),
                mantel.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Rahmen rahmen) {

        // precondition fuer null Objekte
        if(rahmen== null) return null;

        Pair<String,String> beschreibungsPaar = getBeschreibungen(rahmen.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                rahmen.getId(),
                rahmen.getPreis(),
                rahmen.getName(),
                beschreibungsPaar.getKey(),
                beschreibungsPaar.getValue(),
                rahmen.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Sattel sattel) {

        // precondition fuer null Objekte
        if(sattel == null) return null;

        Pair<String,String> beschreibungsPaar = getBeschreibungen(sattel.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                sattel.getId(),
                sattel.getPreis(),
                sattel.getName(),
                beschreibungsPaar.getKey(),
                beschreibungsPaar.getValue(),
                sattel.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Vorbau vorbau) {

        // precondition fuer null Objekte
        if(vorbau == null) return null;

        Pair<String,String> beschreibungsPaar = getBeschreibungen(vorbau.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                vorbau.getId(),
                vorbau.getPreis(),
                "",
                beschreibungsPaar.getKey(),
                beschreibungsPaar.getValue(),
                vorbau.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    @Override
    public EinzelteilDTO toEinzelteilDTO(Zubehoer zubehoer) {

        // precondition fuer null Objekte
        if(zubehoer == null) return null;

        Pair<String,String> beschreibungsPaar = getBeschreibungen(zubehoer.getBeschreibungID());

        EinzelteilDTO einzelteilDTO = new EinzelteilDTO(
                zubehoer.getId(),
                zubehoer.getPreis(),
                zubehoer.getName(),
                beschreibungsPaar.getKey(),
                beschreibungsPaar.getValue(),
                zubehoer.getEinzelTeileTyp().getValue()
        );
        return einzelteilDTO;
    }

    private Pair<String,String> getBeschreibungen(int beschrID){

        List<String> beschreibungen = null;
        Pair<String,String> result = null;

        try {
            beschreibungen = teilePersistenz.getBeschreibungByID(beschrID);

            // preconditon fuer die List laenge
            if(beschreibungen.size() != LIST_LENGTH) return null;

            String kurzbeschreibung = beschreibungen.get(0);
            String werbetext        = beschreibungen.get(1);

            // precondition fuer null Objekte
            if(kurzbeschreibung == null || werbetext == null) return null;

            result = new Pair<String,String>(kurzbeschreibung,werbetext);

        } catch (DatabaseException e) {
            return null;
        }
        
        return result;
    }
}

