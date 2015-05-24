package models.TeileKomponente.Einzelteile;

import models.TeileKomponente.EinzelTeileTyp;

/**
 * Created by dima on 19.05.15.
 */
public class Mantel {

    private int id;
    private int beschreibungID;
    private int formTyp;
    private int formTypID;
    private int durchmesser;
    private int reifengroesse;
    private int preis;
    private String bild;
    private String name;

    private EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.MANTEL;


    private Mantel(int id, int beschreibungID, int formTyp, int formTypID, int durchmesser, int reifengroesse, int preis, String bild, String name) {
        this.id = id;
        this.beschreibungID = beschreibungID;
        this.formTyp = formTyp;
        this.formTypID = formTypID;
        this.durchmesser = durchmesser;
        this.reifengroesse = reifengroesse;
        this.preis = preis;
        this.bild = bild;
        this.name = name;
    }


    static Mantel getValue(int id, int beschreibungID, int formTyp, int formTypID, int durchmesser, int reifengroesse, int preis, String bild, String name){
        return new Mantel(id,beschreibungID,formTyp,formTypID,durchmesser,reifengroesse,preis,bild,name);
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
     * Get FormTyp
     * FormTyp wird anhand einer Nummer
     * @return formtyp
     */
    public int getFormTyp() {
        return formTyp;
    }

    /**
     * Get FormTyp ID
     * FormtypID ist eine eindeutige Nummer eines Formtypes
     * @return
     */
    public int getFormTypID() {
        return formTypID;
    }

    /**
     * Get Durchmesser
     * Durchmesser in cm des Objekts
     * @return durchmesser
     */
    public int getDurchmesser() {
        return durchmesser;
    }

    /**
     * Get Reifengroesse
     * Reifengroesse in zoll
     * @return reifengroesse in zoll
     */
    public int getReifengroesse() {
        return reifengroesse;
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


    public EinzelTeileTyp getEinzelTeileTyp() {
        return einzelTeileTyp;
    }
}