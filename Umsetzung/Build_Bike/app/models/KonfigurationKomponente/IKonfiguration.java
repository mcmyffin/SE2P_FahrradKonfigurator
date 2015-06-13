package models.KonfigurationKomponente;

import models.Exception.KonfigurationException;
import models.Exception.UngueltigerStepException;
import models.KonfigurationKomponente.DTO.KonfigurationDTO;
import models.KonfigurationKomponente.Step.*;
import models.TeileKomponente.EinzelTeileTyp;
import models.TeileKomponente.RahmenFormTyp;

import java.util.List;

/**
 * Created by dima on 24.05.15.
 */
public interface IKonfiguration {


    public IStep_1  getStep1();
    public IStep_2  getStep2();
    public IStep_3  getStep3();
    public IStep_4  getStep4();
    public IStep_5  getStep5();
    public IStep_6  getStep6();
    public IStep_7  getStep7();
    public IStep_8  getStep8();
    public IStep_9  getStep9();
    public IStep_10 getStep10();


    public boolean setStep1(RahmenFormTyp rahmenFormTyp) throws UngueltigerStepException;
    public boolean setStep2(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException;
    public boolean setStep3(String farbe, int rahmenhoehe) throws UngueltigerStepException, KonfigurationException;
    public boolean setStep4(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException;
    public boolean setStep5(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException;
    public boolean setStep6(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException;
    public boolean setStep7(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException;
    public boolean setStep8(int id, EinzelTeileTyp einzelTeileTyp) throws UngueltigerStepException, KonfigurationException;
    public boolean setStep9(boolean isGefragt, boolean isStecklicht, boolean isFestlicht) throws UngueltigerStepException;
    public boolean setStep10(EinzelTeileTyp einzelTeileTyp, List<Integer> ids) throws UngueltigerStepException, KonfigurationException;


    public KonfigurationDTO asDTO();

}
