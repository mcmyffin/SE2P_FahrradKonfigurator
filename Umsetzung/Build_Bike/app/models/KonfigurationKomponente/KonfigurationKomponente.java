package models.KonfigurationKomponente;

import models.Exception.EinzelteileTypException;
import models.Exception.KonfigurationException;
import models.Exception.RahmenFormTypException;
import models.Exception.UngueltigerStepException;
import models.KonfigurationKomponente.DTO.*;
import models.KonfigurationKomponente.Step.IStep_1;
import models.KonfigurationKomponente.Step.IStep_2;
import models.TeileKomponente.EinzelTeileTyp;
import models.TeileKomponente.Einzelteile.*;
import models.TeileKomponente.RahmenFormTyp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dima on 24.05.15.
 */
public class KonfigurationKomponente implements IKofigurationKomponente {


    public KonfigurationKomponente(){}

    // step 5
    @Override
    public List<Felge> filterFelgeByKonfiguration(IKonfiguration konfiguration, List<Felge> felgeList)  throws UngueltigerStepException{

        if(!isStep4(konfiguration)) throw new UngueltigerStepException();

        IStep_2 step_2 = konfiguration.getStep2();
        Rahmen rahmen = step_2.getRahmen();

        List<Felge> felgeResultList = new LinkedList<>();

        for(Felge eineFelge : felgeList){

            if(eineFelge.getReifengroesse() == rahmen.getReifengroesse()){
                felgeResultList.add(eineFelge);
            }
        }

        return felgeResultList;
    }

    // step 4
    @Override
    public List<Gabel> filterGabelByKonfiguration(IKonfiguration konfiguration, List<Gabel> gabelList)  throws UngueltigerStepException{

        if(!isStep3(konfiguration)) throw new UngueltigerStepException();

        IStep_2 step_2 = konfiguration.getStep2();
        Rahmen rahmen = step_2.getRahmen();

        List<Gabel> gabelResultList = new LinkedList<>();

        int rahmenSchafthoehe = rahmen.getSchaftshoehe();
        int rahmenSteuersatz = rahmen.getSteuersatz();

        for(Gabel eineGabel : gabelList){

            if(eineGabel.getSteuersatz() == rahmenSteuersatz && eineGabel.getSchaftslaenge() >= rahmenSchafthoehe &&
                    ((eineGabel.isFelgenbremse() && rahmen.isFelgenbremse()) || eineGabel.isScheibenbremse() && rahmen.isScheibenbremse())){

                gabelResultList.add(eineGabel);
            }
        }

        return gabelResultList;
    }

    // step 6
    @Override
    public List<Mantel> filterMantelByKonfiguration(IKonfiguration konfiguration, List<Mantel> mantelList)  throws UngueltigerStepException{

        if(!isStep5(konfiguration)) throw new UngueltigerStepException();

        IStep_2 step_2 = konfiguration.getStep2();
        Rahmen rahmen = step_2.getRahmen();

        List<Mantel> mantelResultList = new LinkedList<>();

        for(Mantel einMantel : mantelList){

            if(einMantel.getReifengroesse() == rahmen.getReifengroesse()){
                mantelResultList.add(einMantel);
            }
        }
        return mantelResultList;
    }

    // step 8
    @Override
    public List<Sattel> filterSattelByKonfiguration(IKonfiguration konfiguration, List<Sattel> sattelList)  throws UngueltigerStepException{
        if(!isStep7(konfiguration)) throw new UngueltigerStepException();
        return sattelList;
    }

    // step 2
    @Override
    public List<Rahmen> filterRahmenByKonfiguration(IKonfiguration konfiguration, List<Rahmen> rahmenList)  throws UngueltigerStepException{

        if(!isStep1(konfiguration)) throw new UngueltigerStepException();

        IStep_1 step_1 = konfiguration.getStep1();
        RahmenFormTyp rahmenFormTyp = step_1.getRahmenFormTyp();

        List<Rahmen> rahmenResultList = new LinkedList<>();

        for(Rahmen einRahmen : rahmenList){

            if(einRahmen.getFromTyp() == rahmenFormTyp.getNummer()){
                rahmenResultList.add(einRahmen);
            }
        }
        return rahmenResultList;
    }

    // step 7
    @Override
    public List<Vorbau> filterVorbauByKonfiguration(IKonfiguration konfiguration, List<Vorbau> vorbauList)  throws UngueltigerStepException{

        if(!isStep6(konfiguration)) throw new UngueltigerStepException();

        IStep_2 step_2 = konfiguration.getStep2();
        Rahmen rahmen = step_2.getRahmen();

        List<Vorbau> vorbauResultList = new LinkedList<>();

        for(Vorbau einVorbau : vorbauList){

            if(einVorbau.getSchaftsgroesse() == rahmen.getSteuersatz()){
                vorbauResultList.add(einVorbau);
            }
        }
        return vorbauResultList;
    }

    // step 10
    @Override
    public List<Zubehoer> filterZubehoerByKonfiguration(IKonfiguration konfiguration, List<Zubehoer> zubehoerList)  throws UngueltigerStepException{

        if(!isStep9(konfiguration)) throw new UngueltigerStepException();

        return zubehoerList;
    }

    // step 3
    @Override
    public List<String> getRahmenFarbenByKonfiguration(IKonfiguration konfiguration)  throws UngueltigerStepException{

        if(!isStep2(konfiguration)) throw new UngueltigerStepException();

        if(konfiguration.getStep2().getRahmen() != null){

            Rahmen rahmen = konfiguration.getStep2().getRahmen();
            return rahmen.getFarben();
        }
        return null;
    }

    // step 3
    @Override
    public List<Integer> getRahmenHoehenByKonfiguration(IKonfiguration konfiguration)  throws UngueltigerStepException{

        if(!isStep2(konfiguration)) throw new UngueltigerStepException();

        if(konfiguration.getStep2().getRahmen() != null){

            Rahmen rahmen = konfiguration.getStep2().getRahmen();
            return rahmen.getHoehen();
        }
        return null;
    }

    // step 9
    @Override
    public boolean filterFestlicht(IKonfiguration konfiguration)  throws UngueltigerStepException{

        if(!isStep8(konfiguration)) throw new UngueltigerStepException();

        return konfiguration.getStep2().getRahmen().isLicht() && konfiguration.getStep4().getGabel().isLicht();
    }

    private boolean isStep1(IKonfiguration konfiguration){

        if(konfiguration == null) return false;
        return konfiguration.getStep1().getRahmenFormTyp() != null;
    }

    private boolean isStep2(IKonfiguration konfiguration){

        if(!isStep1(konfiguration)) return false;
        return konfiguration.getStep2().getRahmen() != null;
    }

    private boolean isStep3(IKonfiguration konfiguration){

        if(!isStep2(konfiguration)) return false;
        return konfiguration.getStep3().getFarbe() != null;
    }

    private boolean isStep4(IKonfiguration konfiguration){

        if(!isStep3(konfiguration)) return false;
        return konfiguration.getStep4().getGabel() != null;
    }

    private boolean isStep5(IKonfiguration konfiguration){

        if(!isStep4(konfiguration)) return false;
        return konfiguration.getStep5().getFelge() != null;
    }

    private boolean isStep6(IKonfiguration konfiguration){

        if(!isStep5(konfiguration)) return false;
        return konfiguration.getStep6().getMantel() != null;
    }

    private boolean isStep7(IKonfiguration konfiguration){

        if(!isStep6(konfiguration)) return false;
        return konfiguration.getStep7().getVorbau() != null;
    }

    private boolean isStep8(IKonfiguration konfiguration){

        if(!isStep7(konfiguration)) return false;
        return konfiguration.getStep8().getSattel() != null;
    }

    private boolean isStep9(IKonfiguration konfiguration){

        if(!isStep8(konfiguration)) return false;
        return konfiguration.getStep9().isGefragt();
    }

    private boolean isStep10(IKonfiguration konfiguration){

        if(!isStep9(konfiguration)) return false;
        return konfiguration.getStep10().getZubehoerList() != null;
    }



    @Override
    public IKonfiguration fromKonfigurtionDTO(KonfigurationDTO konfigurationDTO) {

        // Wenn keine Konfiguration vorhanden, dann ertelle eine leere
        if(konfigurationDTO == null) return (IKonfiguration) new Konfiguration();

        IKonfiguration konfiguration = new Konfiguration(konfigurationDTO.getKonfigurationsID());

        StepRahmenFormTypDTO step1 = konfigurationDTO.getStep_1();

        if(step1 != null){
            String formtypNummer = step1.getRahmenFormTyp();

            try {
                konfiguration.setStep1(RahmenFormTyp.getRahmenFormTypByString(formtypNummer));
            } catch (UngueltigerStepException|RahmenFormTypException e) {
                // TODO
                e.printStackTrace();
            }
        }

        StepDTO step2 = konfigurationDTO.getStep_2();
        if(step2 != null){

            try {
                int id = step2.getId();
                EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.getEinzelteileTypByString(step2.getEinzelteileTyp());
                konfiguration.setStep2(id, einzelTeileTyp);

            } catch (EinzelteileTypException|UngueltigerStepException|KonfigurationException e) {
                // TODO
                e.printStackTrace();
            }
        }

        StepRahmenFarbeHoehe step3 = konfigurationDTO.getStep_3();
        if(step3 != null){

            try{
                String rahmenfarbe = step3.getRamenfarbe();
                int rahmenhoehe = step3.getRahmenhoehe();
                konfiguration.setStep3(rahmenfarbe,rahmenhoehe);

            } catch (UngueltigerStepException|KonfigurationException e) {
                e.printStackTrace();
            }
        }

        StepDTO step4 = konfigurationDTO.getStep_4();
        if(step4 != null){

            try {
                int id = step4.getId();
                EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.getEinzelteileTypByString(step4.getEinzelteileTyp());
                konfiguration.setStep4(id, einzelTeileTyp);

            } catch (EinzelteileTypException|UngueltigerStepException|KonfigurationException e) {
                // TODO
                e.printStackTrace();
            }
        }

        StepDTO step5 = konfigurationDTO.getStep_5();
        if(step5 != null){

            try {
                int id = step5.getId();
                EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.getEinzelteileTypByString(step5.getEinzelteileTyp());
                konfiguration.setStep5(id, einzelTeileTyp);

            } catch (EinzelteileTypException|UngueltigerStepException|KonfigurationException e) {
                // TODO
                e.printStackTrace();
            }
        }

        StepDTO step6 = konfigurationDTO.getStep_6();
        if(step6 != null){

            try {
                int id = step6.getId();
                EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.getEinzelteileTypByString(step6.getEinzelteileTyp());
                konfiguration.setStep6(id, einzelTeileTyp);

            } catch (EinzelteileTypException|UngueltigerStepException|KonfigurationException e) {
                // TODO
                e.printStackTrace();
            }
        }

        StepDTO step7 = konfigurationDTO.getStep_7();
        if(step7 != null){

            try {
                int id = step7.getId();
                EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.getEinzelteileTypByString(step7.getEinzelteileTyp());
                konfiguration.setStep7(id, einzelTeileTyp);

            } catch (EinzelteileTypException|UngueltigerStepException|KonfigurationException e) {
                // TODO
                e.printStackTrace();
            }
        }

        StepDTO step8 = konfigurationDTO.getStep_8();
        if(step8 != null){

            try {
                int id = step8.getId();
                EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.getEinzelteileTypByString(step8.getEinzelteileTyp());
                konfiguration.setStep8(id, einzelTeileTyp);

            } catch (EinzelteileTypException|UngueltigerStepException|KonfigurationException e) {
                // TODO
                e.printStackTrace();
            }
        }

        StepLichtDTO step9 = konfigurationDTO.getStep_9();
        if(step9 != null){

            try {
                boolean isGefragt = (step9.getGefragt() == 0? false: true);
                boolean isSteckLicht = (step9.getSteckLicht()== 0 ? false: true);
                boolean isFestLicht = (step9.getFestLicht() == 0? false: true);

                konfiguration.setStep9(isGefragt, isSteckLicht , isFestLicht);
            } catch (UngueltigerStepException e) {
                // TODO
                e.printStackTrace();
            }
        }

        StepZubehoerDTO step10 = konfigurationDTO.getStep_10();
        if(step10 != null){

            try {
                int[] zubehoerList = step10.getZubehoerListe();
                EinzelTeileTyp einzelTeileTyp = EinzelTeileTyp.getEinzelteileTypByString(step10.getEinzelteileTyp());

                List<Integer> list = new ArrayList();
                for(int id : zubehoerList){
                    list.add(id);
                }
                konfiguration.setStep10(einzelTeileTyp, list);

            } catch (EinzelteileTypException|KonfigurationException|UngueltigerStepException e) {
                // TODO
                e.printStackTrace();
            }
        }

        return konfiguration;
    }
}
