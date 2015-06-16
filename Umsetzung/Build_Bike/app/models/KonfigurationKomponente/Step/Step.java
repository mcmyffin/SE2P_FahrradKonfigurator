package models.KonfigurationKomponente.Step;

import models.TeileKomponente.Einzelteile.*;
import models.TeileKomponente.RahmenForm;
import models.TeileKomponente.RahmenFormTyp;

import java.util.List;

/**
 * Created by dima on 24.05.15.
 */
public class Step implements IStep {


    // Step 1
    private RahmenFormTyp rahmenFormTyp;

    // Step 2
    private Rahmen rahmen;


    // Step 3
    // Farbe orange#bla#lila
    // Rahmenhöhe 44#12#3234
    // Paser für bauen
    private String farbe;
    private int rahmenHoehe = 0;

    // Step 4
    private Gabel gabel;

    // Step 5
    private Felge felge;

    // Step 6
    private Mantel mantel;

    // Step 7
    private Vorbau vorbau;


    // Step 8
    private Sattel sattel;

    // Step 9
    private boolean isGefragt = false;
    private boolean isSteckLicht = false;
    private boolean isFestLicht = false;

    // Step 10
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
    public String getFarbe() {
        return farbe;
    }

    @Override
    public int getRahmenHoehe() {
        return rahmenHoehe;
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
    public boolean isGefragt() {
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


    /**
     * SETTER **
     */
    @Override
    public void setRahmenFormTyp(RahmenFormTyp rahmenFormTyp) {
        this.rahmenFormTyp = rahmenFormTyp;
    }

    @Override
    public void setRahmen(Rahmen rahmen) {
        this.rahmen = rahmen;
    }

    @Override
    public void setRahmenFarbe(String farbe) {
        this.farbe = farbe;
    }

    @Override
    public void setRahmenHoehe(int rahmenHoehe) {
        this.rahmenHoehe = rahmenHoehe;
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


    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Step)) return false;

        Step aStep = (Step) obj;





        boolean ergebnis = (equalsStep1(this.getRahmenFormTyp(),aStep.getRahmenFormTyp()))&&
                            (equalsStep2(this.getRahmen(),aStep.getRahmen())) &&
                            (equalsStep3(this.getFarbe(),this.getRahmenHoehe(),aStep.getFarbe(),aStep.getRahmenHoehe())) &&
                            (equalsStep4(this.getGabel(),aStep.getGabel()));

    }

    private boolean equalsStep1(RahmenFormTyp rft1,RahmenFormTyp rft2){

        if(rft1 ==  null && rft2 == null) return true;
        if(rft2 != null && rft2 != null){

            boolean ergebnis = true;
            ergebnis &= rft1.getBezeichnung().equals(rft2.getBezeichnung());
            ergebnis &= rft1.getNummer() == rft2.getNummer();
            return ergebnis;

        }else{
            return false;
        }
    }

    private boolean equalsStep2(Rahmen rahmen1, Rahmen rahmen2){

        if(rahmen1 ==  null && rahmen2== null) return true;
        if(rahmen1 != null && rahmen2 != null){

            boolean ergebnis = true;
            ergebnis &= rahmen1.isFelgenbremse() == rahmen2.isFelgenbremse();
            ergebnis &= rahmen1.isGepaektraeger() == rahmen2.isGepaektraeger();
            ergebnis &= rahmen1.isLicht() == rahmen2.isLicht();
            ergebnis &= rahmen1.isScheibenbremse() == rahmen2.isScheibenbremse();
            ergebnis &= rahmen1.getBeschreibungID() == rahmen2.getBeschreibungID();
            ergebnis &= rahmen1.getBild().equals(rahmen2.getBild());
            ergebnis &= rahmen1.getEinzelTeileTyp().equals(rahmen2.getEinzelTeileTyp());
            ergebnis &= rahmen1.getFarben().equals(rahmen2.getFarben());
            ergebnis &= rahmen1.getForm() == rahmen2.getForm();
            ergebnis &= rahmen1.getFormTypID() == rahmen2.getFormTypID();
            ergebnis &= rahmen1.getFromTyp() == rahmen2.getFromTyp();
            ergebnis &= rahmen1.getHoehen().equals(rahmen2.getHoehen());
            ergebnis &= rahmen1.getId() == rahmen2.getId();
            ergebnis &= rahmen1.getName().equals(rahmen2.getName());
            ergebnis &= rahmen1.getPreis() == rahmen2.getPreis();
            ergebnis &= rahmen1.getReifengroesse() == rahmen2.getReifengroesse();
            ergebnis &= rahmen1.getSchaftshoehe() == rahmen2.getSchaftshoehe();
            ergebnis &= rahmen1.getSteuersatz() == rahmen2.getSteuersatz();
            ergebnis &= rahmen1.getTretlager() == rahmen2.getTretlager();
            ergebnis &= rahmen1.getZusatzbefest() == rahmen2.getZusatzbefest();

            return ergebnis;

        }else{
            return false;
        }
    }

    private boolean equalsStep3(String farbe1, int rahmenhoehe1, String farbe2, int rahmenHoehe2){

        if(farbe1 ==  null && farbe2== null) return true;
        if(farbe1 != null && farbe2 != null){

            return farbe1.equals(farbe2) && (rahmenhoehe1 == rahmenHoehe2);

        }else{
            return false;
        }
    }

    private boolean equalsStep4(Gabel gabel1, Gabel gabel2){
        if(gabel1 ==  null && gabel2 == null) return true;
        if(gabel1 != null && gabel2 != null){

            boolean ergebnis = true;

            ergebnis &= gabel1.isFelgenbremse() == gabel2.isFelgenbremse();
            ergebnis &= gabel1.isLicht() == gabel2.isLicht();
            ergebnis &= gabel1.isScheibenbremse() == gabel2.isScheibenbremse();
            ergebnis &= gabel1.getBeschreibungID() == gabel2.getBeschreibungID();
            ergebnis &= gabel1.getBild().equals(gabel2.getBild());
            ergebnis &= gabel1.getEinzelTeileTyp().equals(gabel2.getEinzelTeileTyp());
            ergebnis &= gabel1.getFormTypID() == gabel2.getFormTypID();
            ergebnis &= gabel1.getFromTyp() == gabel2.getFromTyp();
            ergebnis &= gabel1.getId() == gabel2.getId();
            ergebnis &= gabel1.getName().equals(gabel2.getName());
            ergebnis &= gabel1.getPreis() == gabel2.getPreis();
            ergebnis &= gabel1.getReifengroesse() == gabel2.getReifengroesse();
            ergebnis &= gabel1.getSchaftslaenge() == gabel2.getSchaftslaenge();
            ergebnis &= gabel1.getSteuersatz() == gabel2.getSteuersatz();

            return ergebnis;

        }else{
            return false;
        }
    }

//    private boolean equalsStep5(Felge felge1, Felge felge2){
//
//        if(felge1 ==  null && felge2 == null) return true;
//        if(felge1 != null && felge2 != null){
//
//
//        }else{
//            return false;
//        }
//    }


}