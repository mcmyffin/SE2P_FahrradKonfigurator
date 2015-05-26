package models.KonfigurationKomponente.Step;

import models.TeileKomponente.Einzelteile.*;
import models.TeileKomponente.RahmenForm;
import models.TeileKomponente.RahmenFormTyp;

import java.util.List;

/**
 * Created by dima on 24.05.15.
 */
public class Step implements IStep{



    // Step 1
    private RahmenFormTyp rahmenFormTyp;

    // Step 2
    private Rahmen rahmen;

    // Step 3
    private Gabel gabel;

    // Step 4
    private Felge felge;

    // Step 5
    private Mantel mantel;

    // Step 6
    private Vorbau vorbau;

    // Step 7
    private Sattel sattel;

    // Step 8
    private boolean isGefragt = false;
    private boolean isSteckLicht = false;
    private boolean isFestLicht = false;

    // Step 9
    List<Zubehoer> zubehoerList;


    @Override
    public RahmenFormTyp getRahmenFormTyp() {
        return rahmenFormTyp;
    }

    @Override
    public Rahmen getRahmen() {
        return rahmen;
    }

    @Override
    public Gabel getGabel() {
        return gabel;
    }

    @Override
    public Felge getFelge() {
        return felge;
    }

    @Override
    public Mantel getMantel() {
        return mantel;
    }

    @Override
    public Vorbau getVorbau() {
        return vorbau;
    }

    @Override
    public Sattel getSattel() {
        return sattel;
    }

    @Override
    public boolean isGefragt(){
        return isGefragt;
    }

    @Override
    public boolean isSteckLicht() {
        return isSteckLicht;
    }

    @Override
    public boolean isFestLicht() {
        return isFestLicht;
    }

    @Override
    public List<Zubehoer> getZubehoerList() {
        return zubehoerList;
    }

    /*** SETTER ***/
    @Override
    public void setRahmenFormTyp(RahmenFormTyp rahmenFormTyp) {
        this.rahmenFormTyp = rahmenFormTyp;
    }

    @Override
    public void setRahmen(Rahmen rahmen) {
        this.rahmen = rahmen;
    }

    @Override
    public void setGabel(Gabel gabel) {
        this.gabel = gabel;
    }

    @Override
    public void setFelge(Felge felge) {
        this.felge = felge;
    }

    @Override
    public void setMantel(Mantel mantel) {
        this.mantel = mantel;
    }

    @Override
    public void setVorbau(Vorbau vorbau) {
        this.vorbau = vorbau;
    }

    @Override
    public void setSattel(Sattel sattel) {
        this.sattel = sattel;
    }

    @Override
    public void setLicht(boolean isGefragt, boolean isSteckLicht, boolean isFestLicht) {
        this.isGefragt = isGefragt;
        this.isSteckLicht = isSteckLicht;
        this.isFestLicht = isFestLicht;
    }

    @Override
    public void setZubehoerList(List<Zubehoer> zubehoerList) {
        this.zubehoerList = zubehoerList;
    }
}
