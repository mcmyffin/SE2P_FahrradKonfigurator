package models.TeileKomponente.Einzelteile;

/**
 * Created by dima on 25.05.15.
 */
public class FormTyp {

    private int id;
    private int gabel;
    private int felge;
    private int vorbau;
    private int mantel;
    private int rahmen;
    private int teile;
    private int sattel;

    private FormTyp(int id, int gabel, int felge, int vorbau, int mantel, int rahmen, int teile, int sattel) {
        this.id = id;
        this.gabel = gabel;
        this.felge = felge;
        this.vorbau = vorbau;
        this.mantel = mantel;
        this.rahmen = rahmen;
        this.teile = teile;
        this.sattel = sattel;
    }

    static FormTyp getValue(int id, int gabel, int felge, int vorbau, int mantel, int rahmen, int teile, int sattel){
        return new FormTyp(id,gabel,felge,vorbau,mantel,rahmen,teile,sattel);
    }


    public int getId() {
        return id;
    }

    public int getGabel() {
        return gabel;
    }

    public int getFelge() {
        return felge;
    }

    public int getVorbau() {
        return vorbau;
    }

    public int getMantel() {
        return mantel;
    }

    public int getRahmen() {
        return rahmen;
    }

    public int getTeile() {
        return teile;
    }

    public int getSattel() {
        return sattel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)return true;
        if (!(obj instanceof FormTyp)) return false;

        FormTyp formTyp = (FormTyp) obj;
        return (
                formTyp.getFelge() == this.getFelge() &&
                formTyp.getGabel() == this.getGabel() &&
                formTyp.getId() == this.getId() &&
                formTyp.getMantel() == this.getMantel() &&
                formTyp.getRahmen() == this.getRahmen() &&
                formTyp.getSattel() == this.getSattel() &&
                formTyp.getTeile() == this.getTeile() &&
                formTyp.getVorbau() == this.getVorbau()
                );
    }
}
