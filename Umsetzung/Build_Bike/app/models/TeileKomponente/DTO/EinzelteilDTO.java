package models.TeileKomponente.DTO;

import models.TeileKomponente.Einzelteile.Beschreibung;

/**
 * Created by dima on 24.05.15.
 */
public class EinzelteilDTO {

    private final int id;
    private final int preis;
    private final String name;
    private final String kurzbeschreibung;
    private final String werbetext;
    private final String einzelteiletyp;
    private final String bild;

    public EinzelteilDTO(int id, int preis, String name, String kurzbeschreibung, String werbetext  , String einzelteiletyp, String bild) {
        this.id = id;
        this.preis = preis;
        this.name = name;
        this.kurzbeschreibung = kurzbeschreibung;
        this.werbetext = werbetext;
        this.einzelteiletyp = einzelteiletyp;
        this.bild = bild;
    }

    public int getId() {
        return id;
    }

    public int getPreis() {
        return preis;
    }

    public String getName() {
        return name;
    }

    public String getKurzbeschreibung() {
        return kurzbeschreibung;
    }

    public String getWerbetext() {
        return werbetext;
    }

    public String getEinzelteiletyp() {
        return einzelteiletyp;
    }

//    public String getBild() { return bild; }
}
