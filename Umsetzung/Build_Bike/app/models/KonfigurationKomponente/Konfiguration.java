package models.KonfigurationKomponente;

import models.Exception.KonfigurationException;
import models.Exception.UngueltigerStepException;
import models.KonfigurationKomponente.DTO.*;
import models.KonfigurationKomponente.Step.*;
import models.TeileKomponente.*;
import models.TeileKomponente.Einzelteile.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 24.05.15.
 */
public class Konfiguration implements IKonfiguration {


    private long konfigurationsID = System.currentTimeMillis();
    private IStep steps;
    private ITeileKomponente teileKomponente;



    public Konfiguration(){
        steps = new Step();
        teileKomponente = new TeileKomponente();
    }

    Konfiguration(long id){
        this();
        konfigurationsID = id;
    }


    /*** GETTER ***/
    @Override
    public IStep_1 getStep1() {
        return (IStep_1) steps;
    }

    @Override
    public IStep_2 getStep2() {
        return (IStep_2) steps;
    }

    @Override
    public IStep_3 getStep3() {
        return (IStep_3) steps;
    }

    @Override
    public IStep_4 getStep4() {
        return (IStep_4) steps;
    }

    @Override
    public IStep_5 getStep5() {
        return (IStep_5) steps;
    }

    @Override
    public IStep_6 getStep6() {
        return (IStep_6) steps;
    }

    @Override
    public IStep_7 getStep7() {
        return (IStep_7) steps;
    }

    @Override
    public IStep_8 getStep8() {
        return (IStep_8) steps;
    }

    @Override
    public IStep_9 getStep9() {
        return (IStep_9) steps;
    }

    @Override
    public IStep_10 getStep10() { return (IStep_10) steps;}


    /*** SETTER ***/
    @Override
    public boolean setStep1(RahmenFormTyp rahmenformtyp) throws UngueltigerStepException {

        // precondition
        if(rahmenformtyp == null) return false;

        steps.setRahmenFormTyp(rahmenformtyp);
        return true;
    }

    @Override
    public boolean setStep2(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException , KonfigurationException {

        // precondition
        if(!einzelTeileTyp.equals(EinzelTeileTyp.RAHMEN)) throw new KonfigurationException("EinzelteileTyp inkompatibel");
        Rahmen rahmen = teileKomponente.getRahmenByID(id);

        if(rahmen != null){
            steps.setRahmen(rahmen);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean setStep3(String farbe, int rahmenhoehe) throws UngueltigerStepException, KonfigurationException {

        // precondition
        if(farbe == null || rahmenhoehe < 0) return false;

        steps.setRahmenFarbe(farbe);
        steps.setRahmenHoehe(rahmenhoehe);

        return true;
    }

    @Override
    public boolean setStep4(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException {

        // precondition
        if(!einzelTeileTyp.equals(EinzelTeileTyp.GABEL)) throw new KonfigurationException("EinzelteileTyp inkompatibel");
        Gabel gabel = teileKomponente.getGabelByID(id);

        if(gabel != null){
            steps.setGabel(gabel);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean setStep5(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException {

        // precondition
        if(!einzelTeileTyp.equals(EinzelTeileTyp.FELGE)) throw new KonfigurationException("EinzelteileTyp inkompatibel");
        Felge felge = teileKomponente.getFelgeByID(id);

        if(felge != null){
            steps.setFelge(felge);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean setStep6(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException {

        // precondition
        if(!einzelTeileTyp.equals(EinzelTeileTyp.MANTEL)) throw new KonfigurationException("EinzelteileTyp inkompatibel");
        Mantel mantel = teileKomponente.getMantelByID(id);

        if(mantel != null){
            steps.setMantel(mantel);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean setStep7(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException {

        // precondition
        if(!einzelTeileTyp.equals(EinzelTeileTyp.VORBAU)) throw new KonfigurationException("EinzelteileTyp inkompatibel");
        Vorbau vorbau = teileKomponente.getVorbauByID(id);

        if(vorbau != null){
            steps.setVorbau(vorbau);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean setStep8(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException {

        // precondition
        if(!einzelTeileTyp.equals(EinzelTeileTyp.SATTEL)) throw new KonfigurationException("EinzelteileTyp inkompatibel");
        Sattel sattel = teileKomponente.getSattelByID(id);

        if(sattel != null){
            steps.setSattel(sattel);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean setStep9(boolean isGefragt, boolean isStecklicht, boolean isFestlicht) throws UngueltigerStepException {

        steps.setLicht(isGefragt, isStecklicht, isFestlicht);

        return true;
    }

    @Override
    public boolean setStep10(EinzelTeileTyp einzelTeileTyp, List<Integer> ids) throws UngueltigerStepException, KonfigurationException {

        // precondition
        if(!einzelTeileTyp.equals(EinzelTeileTyp.ZUBEHOER)) throw new KonfigurationException("EinzelteileTyp inkompatibel");
        if(ids == null) return false;
        List<Zubehoer> zubehoerList = new ArrayList<>();

        for(int zubehoerID : ids){
            Zubehoer zubehoer = teileKomponente.getZubehoerByID(zubehoerID);
            if(zubehoer == null) return false;

            zubehoerList.add(zubehoer);
        }

        steps.setZubehoerList(zubehoerList);
        return true;
    }

    @Override
    public KonfigurationDTO asDTO() {

        RahmenFormTyp rahmenFormTyp = ((IStep_1)steps).getRahmenFormTyp();
        StepRahmenFormTypDTO stepDTO_1 = null;

        if(rahmenFormTyp != null){
            stepDTO_1 = new StepRahmenFormTypDTO(rahmenFormTyp.getBezeichnung());
        }


        Rahmen rahmen = ((IStep_2) steps).getRahmen();
        StepDTO stepDTO_2 = null;

        if(rahmen != null){
            stepDTO_2 = new StepDTO(rahmen.getId(),rahmen.getEinzelTeileTyp().getValue());
        }


        IStep_3 step3 = ((IStep_3) steps);
        StepRahmenFarbeHoehe stepDTO_3 = null;

        if(step3.getFarbe() != null && step3.getRahmenHoehe() > 0){
            stepDTO_3 = new StepRahmenFarbeHoehe(step3.getFarbe(),step3.getRahmenHoehe());
        }


        Gabel gabel   = ((IStep_4) steps).getGabel();
        StepDTO stepDTO_4 = null;

        if(gabel != null){
            stepDTO_4 = new StepDTO(gabel.getId(),gabel.getEinzelTeileTyp().getValue());
        }


        Felge felge   = ((IStep_5) steps).getFelge();
        StepDTO stepDTO_5 = null;

        if(felge != null){
            stepDTO_5 = new StepDTO(felge.getId(),felge.getEinzelTeileTyp().getValue());
        }


        Mantel mantel = ((IStep_6) steps).getMantel();
        StepDTO stepDTO_6 = null;

        if(mantel != null){
            stepDTO_6 = new StepDTO(mantel.getId(),mantel.getEinzelTeileTyp().getValue());
        }


        Vorbau vorbau = ((IStep_7) steps).getVorbau();
        StepDTO stepDTO_7 = null;

        if(vorbau != null){
            stepDTO_7 =  new StepDTO(vorbau.getId(),vorbau.getEinzelTeileTyp().getValue());
        }


        Sattel sattel = ((IStep_8) steps).getSattel();
        StepDTO stepDTO_8 = null;

        if(sattel != null){
            stepDTO_8 = new StepDTO(sattel.getId(),sattel.getEinzelTeileTyp().getValue());
        }


        IStep_9 step_9 = (IStep_9) steps;
        StepLichtDTO stepDTO_9 = null;

        if(step_9.isGefragt()){
            int istGefragt = (step_9.isGefragt()? 1: 0);
            int isSteckLicht = (step_9.isSteckLicht()? 1:0);
            int isFestLicht = (step_9.isFestLicht()? 1:0);
            stepDTO_9  = new StepLichtDTO(istGefragt,isSteckLicht,isFestLicht);
        }

        IStep_10 step_10 = (IStep_10) steps;
        StepZubehoerDTO stepDTO_10 = null;

        if(step_10.getZubehoerList() != null){

            List<Integer> zubehoerList = new ArrayList<>();

            for(Zubehoer einZubehoer : step_10.getZubehoerList()){

                int id = einZubehoer.getId();
                zubehoerList.add(id);
            }

            stepDTO_10 = new StepZubehoerDTO(zubehoerList,EinzelTeileTyp.ZUBEHOER.getValue());
        }


        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(konfigurationsID,stepDTO_1,stepDTO_2,stepDTO_3,stepDTO_4,stepDTO_5,
                                                                    stepDTO_6,stepDTO_7,stepDTO_8,stepDTO_9,stepDTO_10, getKonfigurationsPreis());

        return konfigurationDTO;
    }

    @Override
    public int getKonfigurationsPreis() {

        Felge felge = steps.getFelge();
        Gabel gabel = steps.getGabel();
        Mantel mantel = steps.getMantel();
        Rahmen rahmen = steps.getRahmen();
        Sattel sattel = steps.getSattel();
        Vorbau vorbau = steps.getVorbau();
        List<Zubehoer> zubehoerList = steps.getZubehoerList();

        int gesamtpreis = 0;

        if(felge != null) gesamtpreis += felge.getPreis();
        if(gabel != null) gesamtpreis += gabel.getPreis();
        if(mantel != null) gesamtpreis += mantel.getPreis();
        if(rahmen != null) gesamtpreis += rahmen.getPreis();
        if(sattel != null) gesamtpreis += sattel.getPreis();
        if(vorbau != null) gesamtpreis += vorbau.getPreis();
        if(zubehoerList != null){

            for(Zubehoer einZubehoer : zubehoerList){

                gesamtpreis += einZubehoer.getPreis();
            }
        }

        return gesamtpreis;
    }

    @Override
    public long getKonfigurationsID() {
        return konfigurationsID;
    }

    @Override
    public String toString() {
        return "Konfiguration[ \n"+
                    "id: "+konfigurationsID+"\n"+
                    "Step01{"+getStep1().getRahmenFormTyp()+"}\n"+
                    "Step02{"+getStep2().getRahmen()+"}\n"+
                    "Step03{farbe: "+getStep3().getFarbe()+", höhe: "+getStep3().getRahmenHoehe()+"}\n"+
                    "Step04{"+getStep4().getGabel()+"}\n"+
                    "Step05{"+getStep5().getFelge()+"}\n"+
                    "Step06{"+getStep6().getMantel()+"}\n"+
                    "Step07{"+getStep7().getVorbau()+"}\n"+
                    "Step08{"+getStep8().getSattel()+"}\n"+
                    "Step09{gefragt: "+getStep9().isGefragt()+" , stecklicht: "+getStep9().isSteckLicht()+" , festlicht: "+ getStep9().isFestLicht()+"}\n"+
                    "Step10{"+getStep10().getZubehoerList()+"}"+" ]";
    }
}
