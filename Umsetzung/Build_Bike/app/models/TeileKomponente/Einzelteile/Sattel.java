package models.TeileKomponente.Einzelteile;

import models.TeileKomponente.EinzelTeileTyp;

/**
 * Created by dima on 19.05.15.
 */
public class Sattel {
    private int id;
    private int beschreibungID;
    private String name;
    private int preis;
    private int formTyp;
    private int formTypID;
    private String bild;

    private EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.SATTEL;

    private Sattel(int id, String name, int beschreibungID, int preis, int formTyp, int formTypID, String bild) {

        this.id = id;
        this.name = name;
        this.beschreibungID = beschreibungID;
        this.preis = preis;
        this.formTyp = formTyp;
        this.formTypID = formTypID;
        this.bild = bild;
    }


    static Sattel getValue(int id, String name, int beschreibungID, int preis, int formTyp, int formTypID, String bild){

        return new Sattel(id,name,beschreibungID,preis,formTyp,formTypID,bild);
    }

    /**
     * Equals
     * Vergleich diese Objekte
     * @return boolean
     */
    @Override
    public boolean equals(Object obj){
        if (obj == this)return true;
        if (!(obj instanceof Sattel)) return false;
        Sattel sattelObj = (Sattel)obj;
        return ((this.id == sattelObj.getId())
                && (this.beschreibungID == sattelObj.getBeschreibungID())
                && (this.preis == sattelObj.getPreis())
                && (this.formTyp == sattelObj.getFormTyp())
                && (this.formTypID == sattelObj.getFormTypID())
                && (this.bild == sattelObj.getBild())
                && (this.name == sattelObj.getName())
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
     * Get Name
     * representiert den Namen des Objekts
     * @return name
     */
    public String getName() {
        return name;
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



    public EinzelTeileTyp getEinzelTeileTyp() {
        return einzelTeileTyp;
    }

    @Override
    public String toString() {
        return "Sattel{" +
                "name='" + name + '\'' +
                '}';
    }
}
