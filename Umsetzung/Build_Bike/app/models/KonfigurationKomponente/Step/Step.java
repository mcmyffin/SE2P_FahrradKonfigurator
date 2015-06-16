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
                            (equalsStep4(this.getGabel(),aStep.getGabel())) &&
                            (equalsStep5(this.getFelge(),aStep.getFelge())) &&
                            (equalsStep6(this.getMantel(),aStep.getMantel())) &&
                            (equalsStep7(this.getVorbau(),aStep.getVorbau())) &&
                            (equalsStep8(this.getSattel(),aStep.getSattel())) &&
                            (equalsStep9(this.isGefragt,this.isSteckLicht,this.isFestLicht,aStep.isGefragt,aStep.isSteckLicht,aStep.isFestLicht)) &&
                            (equalsStep10(this.getZubehoerList(),aStep.getZubehoerList()));

        return ergebnis;
    }

    private boolean equalsStep1(RahmenFormTyp rft1,RahmenFormTyp rft2){

        if(rft1 ==  null && rft2 == null) return true;
        if(rft2 != null && rft2 != null){

            return rft1.equals(rft2);

        }else{
            return false;
        }
    }

    private boolean equalsStep2(Rahmen rahmen1, Rahmen rahmen2){

        if(rahmen1 ==  null && rahmen2== null) return true;
        if(rahmen1 != null && rahmen2 != null){

           return rahmen1.equals(rahmen2);

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

            return gabel1.equals(gabel2);

        }else{
            return false;
        }
    }

    private boolean equalsStep5(Felge felge1, Felge felge2){

        if(felge1 ==  null && felge2 == null) return true;
        if(felge1 != null && felge2 != null){

            return felge1.equals(felge2);
        }else{
            return false;
        }
    }

    private boolean equalsStep6(Mantel mantel1, Mantel mantel2){

        if(mantel1 ==  null && mantel2 == null) return true;
        if(mantel1 != null && mantel2 != null){

            return mantel1.equals(mantel2);
        }else{
            return false;
        }
    }

    private boolean equalsStep7(Vorbau vorbau1, Vorbau vorbau2){

        if(vorbau1 ==  null && vorbau2 == null) return true;
        if(vorbau1 != null && vorbau2 != null){

            return vorbau1.equals(vorbau2);
        }else{
            return false;
        }
    }

    private boolean equalsStep8(Sattel sattel1, Sattel sattel2){

        if(sattel1 ==  null && sattel2== null) return true;
        if(sattel1 != null && sattel2 != null){

            return sattel1.equals(sattel2);
        }else{
            return false;
        }
    }

    private boolean equalsStep9(boolean isGefragt1, boolean isSteckLicht1, boolean isFestLicht1, boolean isGefragt2, boolean isSteckLicht2, boolean isFestLicht2){

        return (isGefragt1 == isGefragt2) && (isSteckLicht1 == isSteckLicht2) && (isFestLicht1 == isFestLicht2);
    }

    private boolean equalsStep10(List<Zubehoer> zubehoerList1, List<Zubehoer> zubehoerList2){

        if(zubehoerList1 == null && zubehoerList2 == null) return true;
        if(zubehoerList1.size() != zubehoerList2.size()) return false;
        for(Zubehoer einZubehoer : zubehoerList1){

            if(!zubehoerList2.contains(einZubehoer)) return false;
        }

        return true;
    }

}