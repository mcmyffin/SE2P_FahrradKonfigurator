package models.TeileKomponente.Einzelteile;

/**
 * Created by dima on 19.05.15.
 */
public class Felge {

    private int id;
    private int beschreibungID;
    private int preis;
    private int reifengroesse;
    private int formTyp;
    private int formTypID;
    private String bild;
    private String name;
    private boolean narbendynamo;

    private Felge(int id, int beschrID, int preis, int reifGr, int formT, int formTID, String bild, String name, boolean narbendynamo){

        this.id = id;
        this.beschreibungID = beschrID;
        this.preis = preis;
        this.reifengroesse = reifGr;
        this.formTyp = formT;
        this.formTypID = formTID;
        this.bild = bild;
        this.name = name;
        this.narbendynamo = narbendynamo;
    }

    static Felge getValue(int id, int beschrID, int preis, int reifGr, int formT, int formTID, String bild, String name, boolean narbendynamo){
        return new Felge(id, beschrID, preis, reifGr, formT, formTID, bild, name, narbendynamo);
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
     * Get Reifengroesse
     * Reifengroesse in cm
     * @return reifengroesse
     */
    public int getReifengroesse() {
        return reifengroesse;
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
     * Is Narbendynamo
     * Wenn ein Narbendynamo im Objekt eingebaut, dann true
     * @return boolean
     */
    public boolean isNarbendynamo() {
        return narbendynamo;
    }
}
