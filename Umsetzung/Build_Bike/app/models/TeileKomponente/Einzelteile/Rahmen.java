package models.TeileKomponente.Einzelteile;

import models.TeileKomponente.EinzelTeileTyp;

import java.util.List;

/**
 * Created by dima on 19.05.15.
 */
public class Rahmen {

    private int id; //
    private List<Integer> hoehen;
    private int form;
    private int reifengroesse; //
    private int beschreibungID;
    private int steuersatz; //
    private int schaftshoehe; //
    private int zusatzbefest; //
    private int tretlager;
    private int fromTyp;
    private int formTypID; //
    private int preis; //
    private String name; //
    private String bild;
    private boolean scheibenbremse; //
    private boolean felgenbremse; //
    private boolean gepaektraeger; //
    private boolean licht; //
    private List<String> farben;


    private EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.RAHMEN;

    private Rahmen(int id, List<Integer> hoehen, int form, int reifengroesse, String bild, int beschreibungID, int steuersatz,
                  int schaftshoehe, int zusatzbefest, boolean scheibenbremse, boolean felgenbremse, int tretlager,
                  int fromTyp, int formTypID, String name, int preis, boolean gepaektraeger, boolean licht, List<String> farben) {

        this.id = id;
        this.hoehen = hoehen;
        this.form = form;
        this.reifengroesse = reifengroesse;
        this.bild = bild;
        this.beschreibungID = beschreibungID;
        this.steuersatz = steuersatz;
        this.schaftshoehe = schaftshoehe;
        this.zusatzbefest = zusatzbefest;
        this.scheibenbremse = scheibenbremse;
        this.felgenbremse = felgenbremse;
        this.tretlager = tretlager;
        this.fromTyp = fromTyp;
        this.formTypID = formTypID;
        this.name = name;
        this.preis = preis;
        this.gepaektraeger = gepaektraeger;
        this.licht = licht;
        this.farben = farben;
    }

    static Rahmen getValue(int id, List<Integer> hoehen, int form, int reifengroesse, String bild, int beschreibungID, int steuersatz,
                           int schaftshoehe, int zusatzbefest, boolean scheibenbremse, boolean felgenbremse, int tretlager,
                           int fromTyp, int formTypID, String name, int preis, boolean gepaektraeger, boolean licht, List<String> farben){

        return new Rahmen(id,hoehen,form,reifengroesse,bild,beschreibungID,steuersatz,schaftshoehe,zusatzbefest,scheibenbremse,
                          felgenbremse,tretlager,fromTyp,formTypID,name,preis,gepaektraeger,licht,farben);
    }

    /**
     * Get ID
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Get Hoehe
     * Hoehen des Objekts in cm
     * @return hoehe
     */
    public List<Integer> getHoehen() {
        return hoehen;
    }

    /**
     * Get Form
     * Eine Nummerische Form
     * @return formnummer
     */
    public int getForm() {
        return form;
    }

    /**
     * Get Reifengroesse
     * Maximale Reifengroesse in cm
     * @return
     */
    public int getReifengroesse() {
        return reifengroesse;
    }

    /**
     * Get Beschreibung ID
     * Eine eindeutige Nummer der Beschreibung des Objekts
     * @return beschreibungID
     */
    public int getBeschreibungID() {
        return beschreibungID;
    }

    /**
     * Get Steuersatz
     * TODO
     * @return TODO
     */
    public int getSteuersatz() {
        return steuersatz;
    }

    /**
     * Get Schaftshoehe
     * TODO
     * @return TODO
     */
    public int getSchaftshoehe() {
        return schaftshoehe;
    }

    /**
     * Get Zusatzbefestigung
     * TODO
     * @return TODO
     */
    public int getZusatzbefest() {
        return zusatzbefest;
    }

    /**
     * Get Tretlager
     * TODO
     * @return TODO
     */
    public int getTretlager() {
        return tretlager;
    }

    /**
     * Get FormTyp
     * Gibt die Nummer des FormTypes an
     * @return formTyp
     */
    public int getFromTyp() {
        return fromTyp;
    }

    /**
     * Get FormTypID
     * @return
     */
    public int getFormTypID() {
        return formTypID;
    }

    /**
     * Get Preis
     * Aktueller Preis des Objekts
     * @return preis
     */
    public int getPreis() {
        return preis;
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
     * Get Bild
     * Bild ist eine Referenz auf den Speicherort des Bildes
     * @return bildspeicherort
     */
    public String getBild() {
        return bild;
    }

    /**
     * Is Scheibenbremse
     * Wenn das Objekt fuer eine Scheibenbremse geeignet ist, dann true
     * @return boolean
     */
    public boolean isScheibenbremse() {
        return scheibenbremse;
    }

    /**
     * Is Felgenbremse
     * Wenn das Objekt fuer eine Felgenbremse geeignet ist, dann true
     * @return boolean
     */
    public boolean isFelgenbremse() {
        return felgenbremse;
    }

    /**
     * Is Gepaektraeger
     * Wenn das Objekt fuer einen Gepaektraeger geeignet ist, dann true
     * @return boolean
     */
    public boolean isGepaektraeger() {
        return gepaektraeger;
    }

    /**
     * Is Licht
     * Wenn das Objekt fuer den Lichtanbau geeignet ist, dann true
     * @return boolean
     */
    public boolean isLicht() {
        return licht;
    }


    /**
     * Get Rahmenfarben
     * Gibt die möglichen Rahmenfarben dieses Objektes als Liste an
     * @return
     */
    public List<String> getFarben() {
        return farben;
    }

    public EinzelTeileTyp getEinzelTeileTyp() {
        return einzelTeileTyp;
    }

}