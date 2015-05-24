package models.TeileKomponente.Einzelteile;

/**
 * Created by dima on 24.05.15.
 */
public class Gabel {

    private int id;
    private int beschreibungID;
    private int fromTyp;
    private int formTypID;
    private int schaftslaenge;
    private int steuersatz;
    private int reifengroesse;
    private int preis;
    private boolean felgenbremse;
    private boolean scheibenbremse;
    private boolean licht;
    private String bild;
    private String name;

    private Gabel(int id, int beschreibungID, int fromTyp, int formTypID, int schaftslaenge, int steuersatz,
                 int reifengroesse, int preis, boolean felgenbremse, boolean scheibenbremse, boolean licht,
                 String bild, String name) {

        this.id = id;
        this.beschreibungID = beschreibungID;
        this.fromTyp = fromTyp;
        this.formTypID = formTypID;
        this.schaftslaenge = schaftslaenge;
        this.steuersatz = steuersatz;
        this.reifengroesse = reifengroesse;
        this.preis = preis;
        this.felgenbremse = felgenbremse;
        this.scheibenbremse = scheibenbremse;
        this.licht = licht;
        this.bild = bild;
        this.name = name;
    }

    static Gabel getValue(int id, int beschreibungID, int fromTyp, int formTypID, int schaftslaenge, int steuersatz,
                          int reifengroesse, int preis, boolean felgenbremse, boolean scheibenbremse, boolean licht,
                          String bild, String name){

        return new Gabel(id,beschreibungID,fromTyp,formTypID,schaftslaenge,steuersatz,reifengroesse,preis,
                felgenbremse,scheibenbremse,licht,bild,name);
    }


    public int getId() {
        return id;
    }

    public int getBeschreibungID() {
        return beschreibungID;
    }

    public int getFromTyp() {
        return fromTyp;
    }

    public int getFormTypID() {
        return formTypID;
    }

    public int getSchaftslaenge() {
        return schaftslaenge;
    }

    public int getSteuersatz() {
        return steuersatz;
    }

    public int getReifengroesse() {
        return reifengroesse;
    }

    public int getPreis() {
        return preis;
    }

    public boolean isFelgenbremse() {
        return felgenbremse;
    }

    public boolean isScheibenbremse() {
        return scheibenbremse;
    }

    public boolean isLicht() {
        return licht;
    }

    public String getBild() {
        return bild;
    }

    public String getName() {
        return name;
    }
}
