package controllers;

import models.Exception.ValuesCreateException;
import models.KonfigurationKomponente.DTO.*;
import models.KonfigurationKomponente.IKonfiguration;
import models.TeileKomponente.EinzelTeileTyp;
import models.TeileKomponente.Einzelteile.Values;
import models.TeileKomponente.RahmenFormTyp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by dima on 25.05.15.
 */
public class KonfigurationSessionTest {



    // Positiver Test auf Uebereinstimmung der EinzelteileTypen
    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_0() {


        // DTO Erzeugen
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(null,null,null,null,null,null,null,null,null,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        assertEquals(konfigurationDTO.getStep_1(),konfigurationDTO_FromSession.getStep_1());
        assertEquals(konfigurationDTO.getStep_2(),konfigurationDTO_FromSession.getStep_2());
        assertEquals(konfigurationDTO.getStep_3(),konfigurationDTO_FromSession.getStep_3());
        assertEquals(konfigurationDTO.getStep_4(),konfigurationDTO_FromSession.getStep_4());
        assertEquals(konfigurationDTO.getStep_5(),konfigurationDTO_FromSession.getStep_5());
        assertEquals(konfigurationDTO.getStep_6(),konfigurationDTO_FromSession.getStep_6());
        assertEquals(konfigurationDTO.getStep_7(),konfigurationDTO_FromSession.getStep_7());
        assertEquals(konfigurationDTO.getStep_8(),konfigurationDTO_FromSession.getStep_8());
        assertEquals(konfigurationDTO.getStep_9(),konfigurationDTO_FromSession.getStep_9());
        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }

    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_1() {


        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,null,null,null,null,null,null,null,null,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(),konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        assertEquals(konfigurationDTO.getStep_2(),konfigurationDTO_FromSession.getStep_2());
        assertEquals(konfigurationDTO.getStep_3(),konfigurationDTO_FromSession.getStep_3());
        assertEquals(konfigurationDTO.getStep_4(),konfigurationDTO_FromSession.getStep_4());
        assertEquals(konfigurationDTO.getStep_5(),konfigurationDTO_FromSession.getStep_5());
        assertEquals(konfigurationDTO.getStep_6(),konfigurationDTO_FromSession.getStep_6());
        assertEquals(konfigurationDTO.getStep_7(),konfigurationDTO_FromSession.getStep_7());
        assertEquals(konfigurationDTO.getStep_8(),konfigurationDTO_FromSession.getStep_8());
        assertEquals(konfigurationDTO.getStep_9(),konfigurationDTO_FromSession.getStep_9());
        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }


    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_2() {


        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        StepDTO              step2DTO = new StepDTO(1,EinzelTeileTyp.RAHMEN.getValue());
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,step2DTO,null,null,null,null,null,null,null,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        // Step1
        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(), konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        // Step2
        assertEquals(konfigurationDTO.getStep_2().getId(),konfigurationDTO_FromSession.getStep_2().getId());
        assertEquals(konfigurationDTO.getStep_2().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_2().getEinzelteileTyp());

        assertEquals(konfigurationDTO.getStep_3(),konfigurationDTO_FromSession.getStep_3());
        assertEquals(konfigurationDTO.getStep_4(),konfigurationDTO_FromSession.getStep_4());
        assertEquals(konfigurationDTO.getStep_5(),konfigurationDTO_FromSession.getStep_5());
        assertEquals(konfigurationDTO.getStep_6(),konfigurationDTO_FromSession.getStep_6());
        assertEquals(konfigurationDTO.getStep_7(),konfigurationDTO_FromSession.getStep_7());
        assertEquals(konfigurationDTO.getStep_8(),konfigurationDTO_FromSession.getStep_8());
        assertEquals(konfigurationDTO.getStep_9(),konfigurationDTO_FromSession.getStep_9());
        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }


    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_3() {


        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        StepDTO              step2DTO = new StepDTO(1,EinzelTeileTyp.RAHMEN.getValue());
        StepRahmenFarbeHoehe step3DTO = new StepRahmenFarbeHoehe("blau",12);
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,step2DTO,step3DTO,null,null,null,null,null,null,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        // Step1
        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(), konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        // Step2
        assertEquals(konfigurationDTO.getStep_2().getId(),konfigurationDTO_FromSession.getStep_2().getId());
        assertEquals(konfigurationDTO.getStep_2().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_2().getEinzelteileTyp());
        // Step3
        assertEquals(konfigurationDTO.getStep_3().getRahmenhoehe(),konfigurationDTO_FromSession.getStep_3().getRahmenhoehe());
        assertEquals(konfigurationDTO.getStep_3().getRamenfarbe(),konfigurationDTO_FromSession.getStep_3().getRamenfarbe());

        assertEquals(konfigurationDTO.getStep_4(),konfigurationDTO_FromSession.getStep_4());
        assertEquals(konfigurationDTO.getStep_5(),konfigurationDTO_FromSession.getStep_5());
        assertEquals(konfigurationDTO.getStep_6(),konfigurationDTO_FromSession.getStep_6());
        assertEquals(konfigurationDTO.getStep_7(),konfigurationDTO_FromSession.getStep_7());
        assertEquals(konfigurationDTO.getStep_8(),konfigurationDTO_FromSession.getStep_8());
        assertEquals(konfigurationDTO.getStep_9(),konfigurationDTO_FromSession.getStep_9());
        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }


    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_4() {


        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        StepDTO              step2DTO = new StepDTO(1,EinzelTeileTyp.RAHMEN.getValue());
        StepRahmenFarbeHoehe step3DTO = new StepRahmenFarbeHoehe("blau",12);
        StepDTO              step4DTO = new StepDTO(2,EinzelTeileTyp.GABEL.getValue());
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,step2DTO,step3DTO,step4DTO,null,null,null,null,null,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        // Step1
        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(), konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        // Step2
        assertEquals(konfigurationDTO.getStep_2().getId(),konfigurationDTO_FromSession.getStep_2().getId());
        assertEquals(konfigurationDTO.getStep_2().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_2().getEinzelteileTyp());
        // Step3
        assertEquals(konfigurationDTO.getStep_3().getRahmenhoehe(),konfigurationDTO_FromSession.getStep_3().getRahmenhoehe());
        assertEquals(konfigurationDTO.getStep_3().getRamenfarbe(),konfigurationDTO_FromSession.getStep_3().getRamenfarbe());
        // Step4
        assertEquals(konfigurationDTO.getStep_4().getId(),konfigurationDTO_FromSession.getStep_4().getId());
        assertEquals(konfigurationDTO.getStep_4().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_4().getEinzelteileTyp());

        assertEquals(konfigurationDTO.getStep_5(),konfigurationDTO_FromSession.getStep_5());
        assertEquals(konfigurationDTO.getStep_6(),konfigurationDTO_FromSession.getStep_6());
        assertEquals(konfigurationDTO.getStep_7(),konfigurationDTO_FromSession.getStep_7());
        assertEquals(konfigurationDTO.getStep_8(),konfigurationDTO_FromSession.getStep_8());
        assertEquals(konfigurationDTO.getStep_9(),konfigurationDTO_FromSession.getStep_9());
        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }


    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_5() {


        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        StepDTO              step2DTO = new StepDTO(1,EinzelTeileTyp.RAHMEN.getValue());
        StepRahmenFarbeHoehe step3DTO = new StepRahmenFarbeHoehe("blau",12);
        StepDTO              step4DTO = new StepDTO(2,EinzelTeileTyp.GABEL.getValue());
        StepDTO              step5DTO = new StepDTO(3,EinzelTeileTyp.FELGE.getValue());
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,step2DTO,step3DTO,step4DTO,step5DTO,null,null,null,null,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        // Step1
        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(), konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        // Step2
        assertEquals(konfigurationDTO.getStep_2().getId(),konfigurationDTO_FromSession.getStep_2().getId());
        assertEquals(konfigurationDTO.getStep_2().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_2().getEinzelteileTyp());
        // Step3
        assertEquals(konfigurationDTO.getStep_3().getRahmenhoehe(),konfigurationDTO_FromSession.getStep_3().getRahmenhoehe());
        assertEquals(konfigurationDTO.getStep_3().getRamenfarbe(),konfigurationDTO_FromSession.getStep_3().getRamenfarbe());
        // Step4
        assertEquals(konfigurationDTO.getStep_4().getId(),konfigurationDTO_FromSession.getStep_4().getId());
        assertEquals(konfigurationDTO.getStep_4().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_4().getEinzelteileTyp());
        // Step5
        assertEquals(konfigurationDTO.getStep_5().getId(),konfigurationDTO_FromSession.getStep_5().getId());
        assertEquals(konfigurationDTO.getStep_5().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_5().getEinzelteileTyp());

        assertEquals(konfigurationDTO.getStep_6(),konfigurationDTO_FromSession.getStep_6());
        assertEquals(konfigurationDTO.getStep_7(),konfigurationDTO_FromSession.getStep_7());
        assertEquals(konfigurationDTO.getStep_8(),konfigurationDTO_FromSession.getStep_8());
        assertEquals(konfigurationDTO.getStep_9(),konfigurationDTO_FromSession.getStep_9());
        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }


    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_6() {


        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        StepDTO              step2DTO = new StepDTO(1,EinzelTeileTyp.RAHMEN.getValue());
        StepRahmenFarbeHoehe step3DTO = new StepRahmenFarbeHoehe("blau",12);
        StepDTO              step4DTO = new StepDTO(2,EinzelTeileTyp.GABEL.getValue());
        StepDTO              step5DTO = new StepDTO(3,EinzelTeileTyp.FELGE.getValue());
        StepDTO              step6DTO = new StepDTO(4,EinzelTeileTyp.MANTEL.getValue());
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,step2DTO,step3DTO,step4DTO,step5DTO,step6DTO,null,null,null,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        // Step1
        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(), konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        // Step2
        assertEquals(konfigurationDTO.getStep_2().getId(),konfigurationDTO_FromSession.getStep_2().getId());
        assertEquals(konfigurationDTO.getStep_2().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_2().getEinzelteileTyp());
        // Step3
        assertEquals(konfigurationDTO.getStep_3().getRahmenhoehe(),konfigurationDTO_FromSession.getStep_3().getRahmenhoehe());
        assertEquals(konfigurationDTO.getStep_3().getRamenfarbe(),konfigurationDTO_FromSession.getStep_3().getRamenfarbe());
        // Step4
        assertEquals(konfigurationDTO.getStep_4().getId(),konfigurationDTO_FromSession.getStep_4().getId());
        assertEquals(konfigurationDTO.getStep_4().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_4().getEinzelteileTyp());
        // Step5
        assertEquals(konfigurationDTO.getStep_5().getId(),konfigurationDTO_FromSession.getStep_5().getId());
        assertEquals(konfigurationDTO.getStep_5().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_5().getEinzelteileTyp());
        // Step6
        assertEquals(konfigurationDTO.getStep_6().getId(),konfigurationDTO_FromSession.getStep_6().getId());
        assertEquals(konfigurationDTO.getStep_6().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_6().getEinzelteileTyp());

        assertEquals(konfigurationDTO.getStep_7(),konfigurationDTO_FromSession.getStep_7());
        assertEquals(konfigurationDTO.getStep_8(),konfigurationDTO_FromSession.getStep_8());
        assertEquals(konfigurationDTO.getStep_9(),konfigurationDTO_FromSession.getStep_9());
        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }


    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_7() {

        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        StepDTO              step2DTO = new StepDTO(1,EinzelTeileTyp.RAHMEN.getValue());
        StepRahmenFarbeHoehe step3DTO = new StepRahmenFarbeHoehe("blau",12);
        StepDTO              step4DTO = new StepDTO(2,EinzelTeileTyp.GABEL.getValue());
        StepDTO              step5DTO = new StepDTO(3,EinzelTeileTyp.FELGE.getValue());
        StepDTO              step6DTO = new StepDTO(4,EinzelTeileTyp.MANTEL.getValue());
        StepDTO              step7DTO = new StepDTO(4,EinzelTeileTyp.VORBAU.getValue());
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,step2DTO,step3DTO,step4DTO,step5DTO,step6DTO,step7DTO,null,null,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        // Step1
        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(),konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        // Step2
        assertEquals(konfigurationDTO.getStep_2().getId(),konfigurationDTO_FromSession.getStep_2().getId());
        assertEquals(konfigurationDTO.getStep_2().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_2().getEinzelteileTyp());
        // Step3
        assertEquals(konfigurationDTO.getStep_3().getRahmenhoehe(),konfigurationDTO_FromSession.getStep_3().getRahmenhoehe());
        assertEquals(konfigurationDTO.getStep_3().getRamenfarbe(),konfigurationDTO_FromSession.getStep_3().getRamenfarbe());
        // Step4
        assertEquals(konfigurationDTO.getStep_4().getId(),konfigurationDTO_FromSession.getStep_4().getId());
        assertEquals(konfigurationDTO.getStep_4().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_4().getEinzelteileTyp());
        // Step5
        assertEquals(konfigurationDTO.getStep_5().getId(),konfigurationDTO_FromSession.getStep_5().getId());
        assertEquals(konfigurationDTO.getStep_5().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_5().getEinzelteileTyp());
        // Step6
        assertEquals(konfigurationDTO.getStep_6().getId(),konfigurationDTO_FromSession.getStep_6().getId());
        assertEquals(konfigurationDTO.getStep_6().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_6().getEinzelteileTyp());
        // Step7
        assertEquals(konfigurationDTO.getStep_7().getId(),konfigurationDTO_FromSession.getStep_7().getId());
        assertEquals(konfigurationDTO.getStep_7().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_7().getEinzelteileTyp());

        assertEquals(konfigurationDTO.getStep_8(),konfigurationDTO_FromSession.getStep_8());
        assertEquals(konfigurationDTO.getStep_9(),konfigurationDTO_FromSession.getStep_9());
        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }


    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_8() {

        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        StepDTO              step2DTO = new StepDTO(1,EinzelTeileTyp.RAHMEN.getValue());
        StepRahmenFarbeHoehe step3DTO = new StepRahmenFarbeHoehe("blau",12);
        StepDTO              step4DTO = new StepDTO(2,EinzelTeileTyp.GABEL.getValue());
        StepDTO              step5DTO = new StepDTO(3,EinzelTeileTyp.FELGE.getValue());
        StepDTO              step6DTO = new StepDTO(4,EinzelTeileTyp.MANTEL.getValue());
        StepDTO              step7DTO = new StepDTO(4,EinzelTeileTyp.VORBAU.getValue());
        StepDTO              step8DTO = new StepDTO(4,EinzelTeileTyp.SATTEL.getValue());
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,step2DTO,step3DTO,step4DTO,step5DTO,step6DTO,step7DTO,step8DTO,null,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        // Step1
        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(),konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        // Step2
        assertEquals(konfigurationDTO.getStep_2().getId(),konfigurationDTO_FromSession.getStep_2().getId());
        assertEquals(konfigurationDTO.getStep_2().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_2().getEinzelteileTyp());
        // Step3
        assertEquals(konfigurationDTO.getStep_3().getRahmenhoehe(),konfigurationDTO_FromSession.getStep_3().getRahmenhoehe());
        assertEquals(konfigurationDTO.getStep_3().getRamenfarbe(),konfigurationDTO_FromSession.getStep_3().getRamenfarbe());
        // Step4
        assertEquals(konfigurationDTO.getStep_4().getId(),konfigurationDTO_FromSession.getStep_4().getId());
        assertEquals(konfigurationDTO.getStep_4().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_4().getEinzelteileTyp());
        // Step5
        assertEquals(konfigurationDTO.getStep_5().getId(),konfigurationDTO_FromSession.getStep_5().getId());
        assertEquals(konfigurationDTO.getStep_5().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_5().getEinzelteileTyp());
        // Step6
        assertEquals(konfigurationDTO.getStep_6().getId(),konfigurationDTO_FromSession.getStep_6().getId());
        assertEquals(konfigurationDTO.getStep_6().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_6().getEinzelteileTyp());
        // Step7
        assertEquals(konfigurationDTO.getStep_7().getId(),konfigurationDTO_FromSession.getStep_7().getId());
        assertEquals(konfigurationDTO.getStep_7().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_7().getEinzelteileTyp());
        // Step8
        assertEquals(konfigurationDTO.getStep_8().getId(),konfigurationDTO_FromSession.getStep_8().getId());
        assertEquals(konfigurationDTO.getStep_8().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_8().getEinzelteileTyp());

        assertEquals(konfigurationDTO.getStep_9(),konfigurationDTO_FromSession.getStep_9());
        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }


    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_9() {

        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        StepDTO              step2DTO = new StepDTO(1,EinzelTeileTyp.RAHMEN.getValue());
        StepRahmenFarbeHoehe step3DTO = new StepRahmenFarbeHoehe("blau",12);
        StepDTO              step4DTO = new StepDTO(2,EinzelTeileTyp.GABEL.getValue());
        StepDTO              step5DTO = new StepDTO(3,EinzelTeileTyp.FELGE.getValue());
        StepDTO              step6DTO = new StepDTO(4,EinzelTeileTyp.MANTEL.getValue());
        StepDTO              step7DTO = new StepDTO(4,EinzelTeileTyp.VORBAU.getValue());
        StepDTO              step8DTO = new StepDTO(4,EinzelTeileTyp.SATTEL.getValue());
        StepLichtDTO         step9DTO = new StepLichtDTO(true,true,false);
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,step2DTO,step3DTO,step4DTO,step5DTO,step6DTO,step7DTO,step8DTO,step9DTO,null);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        // Step1
        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(),konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        // Step2
        assertEquals(konfigurationDTO.getStep_2().getId(),konfigurationDTO_FromSession.getStep_2().getId());
        assertEquals(konfigurationDTO.getStep_2().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_2().getEinzelteileTyp());
        // Step3
        assertEquals(konfigurationDTO.getStep_3().getRahmenhoehe(),konfigurationDTO_FromSession.getStep_3().getRahmenhoehe());
        assertEquals(konfigurationDTO.getStep_3().getRamenfarbe(),konfigurationDTO_FromSession.getStep_3().getRamenfarbe());
        // Step4
        assertEquals(konfigurationDTO.getStep_4().getId(),konfigurationDTO_FromSession.getStep_4().getId());
        assertEquals(konfigurationDTO.getStep_4().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_4().getEinzelteileTyp());
        // Step5
        assertEquals(konfigurationDTO.getStep_5().getId(),konfigurationDTO_FromSession.getStep_5().getId());
        assertEquals(konfigurationDTO.getStep_5().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_5().getEinzelteileTyp());
        // Step6
        assertEquals(konfigurationDTO.getStep_6().getId(),konfigurationDTO_FromSession.getStep_6().getId());
        assertEquals(konfigurationDTO.getStep_6().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_6().getEinzelteileTyp());
        // Step7
        assertEquals(konfigurationDTO.getStep_7().getId(),konfigurationDTO_FromSession.getStep_7().getId());
        assertEquals(konfigurationDTO.getStep_7().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_7().getEinzelteileTyp());
        // Step8
        assertEquals(konfigurationDTO.getStep_8().getId(),konfigurationDTO_FromSession.getStep_8().getId());
        assertEquals(konfigurationDTO.getStep_8().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_8().getEinzelteileTyp());
        // Step9
        assertEquals(konfigurationDTO.getStep_9().isGefragt(),konfigurationDTO_FromSession.getStep_9().isGefragt());
        assertEquals(konfigurationDTO.getStep_9().isFestLicht(),konfigurationDTO_FromSession.getStep_9().isFestLicht());
        assertEquals(konfigurationDTO.getStep_9().isSteckLicht(),konfigurationDTO_FromSession.getStep_9().isSteckLicht());

        assertEquals(konfigurationDTO.getStep_10(),konfigurationDTO_FromSession.getStep_10());

    }


    @Test
    public void testDTOAufPersistenzNachSpeicherungDerSessionKonfiguration_10() {

        // DTO Erzeugen
        StepRahmenFormTypDTO step1DTO = new StepRahmenFormTypDTO(RahmenFormTyp.CITTY_BIKE.getBezeichnung());
        StepDTO              step2DTO = new StepDTO(1,EinzelTeileTyp.RAHMEN.getValue());
        StepRahmenFarbeHoehe step3DTO = new StepRahmenFarbeHoehe("blau",12);
        StepDTO              step4DTO = new StepDTO(2,EinzelTeileTyp.GABEL.getValue());
        StepDTO              step5DTO = new StepDTO(3,EinzelTeileTyp.FELGE.getValue());
        StepDTO              step6DTO = new StepDTO(4,EinzelTeileTyp.MANTEL.getValue());
        StepDTO              step7DTO = new StepDTO(4,EinzelTeileTyp.VORBAU.getValue());
        StepDTO              step8DTO = new StepDTO(4,EinzelTeileTyp.SATTEL.getValue());
        StepLichtDTO         step9DTO = new StepLichtDTO(true,true,false);

        int[] ids = {12,13,14,15,99,1};
        List<Integer> zubehoerlist = new ArrayList(Arrays.asList(ids));
        StepZubehoerDTO      step10DTO= new StepZubehoerDTO(zubehoerlist,EinzelTeileTyp.ZUBEHOER.getValue());
        KonfigurationDTO konfigurationDTO = new KonfigurationDTO(step1DTO,step2DTO,step3DTO,step4DTO,step5DTO,step6DTO,step7DTO,step8DTO,step9DTO,step10DTO);

        // In Session speichern
        KonfigurationSession.setKonfigurationInSession(konfigurationDTO);
        // Aus Session laden
        KonfigurationDTO konfigurationDTO_FromSession = KonfigurationSession.getKonfigurationFromSession();

        // Auf Persistenz pruefen
        // Step1
        assertEquals(konfigurationDTO.getStep_1().getRahmenFormTyp(),konfigurationDTO_FromSession.getStep_1().getRahmenFormTyp());
        // Step2
        assertEquals(konfigurationDTO.getStep_2().getId(),konfigurationDTO_FromSession.getStep_2().getId());
        assertEquals(konfigurationDTO.getStep_2().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_2().getEinzelteileTyp());
        // Step3
        assertEquals(konfigurationDTO.getStep_3().getRahmenhoehe(),konfigurationDTO_FromSession.getStep_3().getRahmenhoehe());
        assertEquals(konfigurationDTO.getStep_3().getRamenfarbe(),konfigurationDTO_FromSession.getStep_3().getRamenfarbe());
        // Step4
        assertEquals(konfigurationDTO.getStep_4().getId(),konfigurationDTO_FromSession.getStep_4().getId());
        assertEquals(konfigurationDTO.getStep_4().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_4().getEinzelteileTyp());
        // Step5
        assertEquals(konfigurationDTO.getStep_5().getId(),konfigurationDTO_FromSession.getStep_5().getId());
        assertEquals(konfigurationDTO.getStep_5().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_5().getEinzelteileTyp());
        // Step6
        assertEquals(konfigurationDTO.getStep_6().getId(),konfigurationDTO_FromSession.getStep_6().getId());
        assertEquals(konfigurationDTO.getStep_6().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_6().getEinzelteileTyp());
        // Step7
        assertEquals(konfigurationDTO.getStep_7().getId(),konfigurationDTO_FromSession.getStep_7().getId());
        assertEquals(konfigurationDTO.getStep_7().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_7().getEinzelteileTyp());
        // Step8
        assertEquals(konfigurationDTO.getStep_8().getId(),konfigurationDTO_FromSession.getStep_8().getId());
        assertEquals(konfigurationDTO.getStep_8().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_8().getEinzelteileTyp());
        // Step9
        assertEquals(konfigurationDTO.getStep_9().isGefragt(),konfigurationDTO_FromSession.getStep_9().isGefragt());
        assertEquals(konfigurationDTO.getStep_9().isFestLicht(),konfigurationDTO_FromSession.getStep_9().isFestLicht());
        assertEquals(konfigurationDTO.getStep_9().isSteckLicht(),konfigurationDTO_FromSession.getStep_9().isSteckLicht());
        // Step10
        assertEquals(konfigurationDTO.getStep_10().getEinzelteileTyp(),konfigurationDTO_FromSession.getStep_10().getEinzelteileTyp());
        assertEquals(konfigurationDTO.getStep_10().getZubehoerListe(),konfigurationDTO_FromSession.getStep_10().getZubehoerListe());
        assertEquals(konfigurationDTO.getStep_10().getZubehoerListe().size(),konfigurationDTO_FromSession.getStep_10().getZubehoerListe().size());

    }






}
