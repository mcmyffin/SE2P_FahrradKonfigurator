package models.TeileKomponente.Einzelteile;

import models.TeileKomponente.EinzelTeileTyp;

/**
 * Created by dima on 19.05.15.
 */
public class Vorbau {
    private int id;
    private int beschreibungID;
    private int preis;
    private int schaftsgroesse;
    private int formTyp;
    private int formTypID;
    private String bild;

    private EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.VORBAU;

    private Vorbau(int id, int beschreibungID, int preis, int schaftsgroesse, int formTyp, int formTypId, String bild) {
        this.id = id;
        this.beschreibungID = beschreibungID;
        this.preis = preis;
        this.schaftsgroesse = schaftsgroesse;
        this.formTyp = formTyp;
        this.formTypID = formTypId;
        this.bild = bild;
    }

    static Vorbau getValue(int id, int beschreibungID, int preis, int schaftsgroesse, int formTyp, int formTypId, String bild){

        return new Vorbau(id,beschreibungID,preis,schaftsgroesse,formTyp,formTypId,bild);
    }

    /**
     * Equals
     * Vergleich diese Objekte
     * @return boolean
     */

    public boolean equals(Object obj){
        if (obj == this)return true;
        if (!(obj instanceof Felge)) return false;
        Vorbau vorbauObj = (Vorbau)obj;
        return ((this.id == vorbauObj.getId())
                && (this.beschreibungID == vorbauObj.getBeschreibungID())
                && (this.preis == vorbauObj.getPreis())
                && (this.formTyp == vorbauObj.getFormTyp())
                && (this.formTypID == vorbauObj.getFormTypID())
                && (this.bild == vorbauObj.getBild())
                && (this.schaftsgroesse == vorbauObj.getSchaftsgroesse())
        );
    }

    /**
     * Get ID
     * Eine eindeutige Nummer dieses Objektes
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Get BeschreibungID
     * Eine eindeutige Nummer der Beschreibung
     * @return beschreibungID
     */
    public int getBeschreibungID() {
        return beschreibungID;
    }

    /**
     * Get Preis
     * Aktueller Preis dieses Objektes
     * @return preis
     */
    public int getPreis() {
        return preis;
    }

    /**
     * Get Schaftsgroesse
     *  TODO
     * @return TODO
     */
    public int getSchaftsgroesse() {
        return schaftsgroesse;
    }

    /**
     * Get FormTyp
     * FormTyp wird anhand einer Nummer
     * @return formtyp
     */
    public int getFormTyp() {
        return formTyp;
    }

    /**
     * Get FormTyp ID
     * FormTypID ist eine eindeutige Nummer eines Formtypes
     * @return formtypID
     */
    public int getFormTypID() {
        return formTypID;
    }

    /**
     * Get Bild
     * Bild ist eine Referenz auf den Speicherort des Bildes
     * @return bildspeicherort
     */
    public String getBild() {
        return bild;
    }


    public EinzelTeileTyp getEinzelTeileTyp() {
        return einzelTeileTyp;
    }
}
