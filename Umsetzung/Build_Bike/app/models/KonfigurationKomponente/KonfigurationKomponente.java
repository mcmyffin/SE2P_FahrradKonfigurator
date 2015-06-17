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

    @Override
    public List<Felge> filterFelgeByKonfiguration(IKonfiguration konfiguration, List<Felge> felgeList) {

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

    @Override
    public List<Gabel> filterGabelByKonfiguration(IKonfiguration konfiguration, List<Gabel> gabelList) {

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

    @Override
    public List<Mantel> filterMantelByKonfiguration(IKonfiguration konfiguration, List<Mantel> mantelList) {

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

    @Override
    public List<Sattel> filterSattelByKonfiguration(IKonfiguration konfiguration, List<Sattel> sattelList) {
        return sattelList;
    }

    @Override
    public List<Rahmen> filterRahmenByKonfiguration(IKonfiguration konfiguration, List<Rahmen> rahmenList) {

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

    @Override
    public List<Vorbau> filterVorbauByKonfiguration(IKonfiguration konfiguration, List<Vorbau> vorbauList) {

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

    @Override
    public List<Zubehoer> filterZubehoerByKonfiguration(IKonfiguration konfiguration, List<Zubehoer> zubehoerList) {
        return zubehoerList;
    }

    @Override
    public IKonfiguration fromKonfigurtionDTO(KonfigurationDTO konfigurationDTO) {

        IKonfiguration konfiguration = new Konfiguration();

        // Wenn keine Konfiguration vorhanden, dann ertelle eine leere
        if(konfigurationDTO == null) return konfiguration;

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

    @Override
    public List<String> getRahmenFarbenByKonfiguration(IKonfiguration konfiguration) {

        if(konfiguration.getStep2().getRahmen() != null){

            Rahmen rahmen = konfiguration.getStep2().getRahmen();
            return rahmen.getFarben();
        }
        return null;
    }

    @Override
    public List<Integer> getRahmenHoehenByKonfiguration(IKonfiguration konfiguration) {

        if(konfiguration.getStep2().getRahmen() != null){

            Rahmen rahmen = konfiguration.getStep2().getRahmen();
            return rahmen.getHoehen();
        }
        return null;
    }

    @Override
    public boolean filterFestlicht(IKonfiguration konfiguration) {

        return konfiguration.getStep2().getRahmen().isLicht() && konfiguration.getStep4().getGabel().isLicht();
    }
}
