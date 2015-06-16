package models.TeileKomponente.Einzelteile;

import models.TeileKomponente.EinzelTeileTyp;

/**
 * Created by dima on 19.05.15.
 */
public class Zubehoer {

    private int id;
    private int beschreibungID;
    private int preis;
    private int formTyp;
    private int formTypID;
    private String bild;
    private String name;
    private boolean zusatzBelegt;

    private EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.ZUBEHOER;

    private Zubehoer(int id, int beschreibungID, int preis, int formTyp, int formTypID, String bild, String name, boolean zusatzBelegt) {
        this.id = id;
        this.beschreibungID = beschreibungID;
        this.preis = preis;
        this.formTyp = formTyp;
        this.formTypID = formTypID;
        this.bild = bild;
        this.name = name;
        this.zusatzBelegt = zusatzBelegt;
    }

    static Zubehoer getValue(int id, int beschreibungID, int preis, int formTyp, int formTypID, String bild, String name, boolean zusatzBelegt){

        return new Zubehoer(id,beschreibungID,preis,formTyp,formTypID,bild,name,zusatzBelegt);
    }

    /**
     * Equals
     * Vergleich diese Objekte
     * @return boolean
     */
    @Override
    public boolean equals(Object obj){
        if (obj == this)return true;
        if (!(obj instanceof Zubehoer)) return false;
        Zubehoer zubObj = (Zubehoer)obj;
        return ((this.id == zubObj.getId()) && (this.beschreibungID == zubObj.getBeschreibungID()) &&
                (this.preis == zubObj.getPreis()) && (this.formTyp == zubObj.getFormTyp()) &&
                (this.formTypID == zubObj.getFormTypID()) && (this.bild == zubObj.getBild()) &&
                (this.name == zubObj.getName()) && (this.zusatzBelegt == zubObj.isZusatzBelegt()));
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

    /**
     * Get Name
     * representiert den Namen des Objekts
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get ZusatzBelegt
     *  TODO
     * @return TODO
     */
    public boolean isZusatzBelegt() {
        return zusatzBelegt;
    }


    public EinzelTeileTyp getEinzelTeileTyp() {
        return einzelTeileTyp;
    }
}
