package models.KonfigurationKomponente.DTO;

/**
 * Created by dima on 25.05.15.
 */
public class KonfigurationDTO {


    private StepRahmenFormTypDTO step_1;
    private StepDTO step_2;
    private StepRahmenFarbeHoehe step_3;
    private StepDTO step_4;
    private StepDTO step_5;
    private StepDTO step_6;
    private StepDTO step_7;
    private StepDTO step_8;
    private StepLichtDTO step_9;
    private StepZubehoerDTO step_10;
    private int gesamtPreis = 0;

    public KonfigurationDTO(){};

    public KonfigurationDTO(StepRahmenFormTypDTO step_1, StepDTO step_2, StepRahmenFarbeHoehe step_3, StepDTO step_4, StepDTO step_5,
                            StepDTO step_6, StepDTO step_7, StepDTO step_8, StepLichtDTO step_9, StepZubehoerDTO step_10, int gesamtPreis) {

        this.step_1 = step_1;
        this.step_2 = step_2;
        this.step_3 = step_3;
        this.step_4 = step_4;
        this.step_5 = step_5;
        this.step_6 = step_6;
        this.step_7 = step_7;
        this.step_8 = step_8;
        this.step_9 = step_9;
        this.step_10 = step_10;
        this.gesamtPreis = gesamtPreis;
    }


    /*** GETTER ***/
    public StepRahmenFormTypDTO getStep_1() {
        return step_1;
    }

    public StepDTO getStep_2() {
        return step_2;
    }

    public StepRahmenFarbeHoehe getStep_3() { return step_3; }

    public StepDTO getStep_4() {
        return step_4;
    }

    public StepDTO getStep_5() {
        return step_5;
    }

    public StepDTO getStep_6() {
        return step_6;
    }

    public StepDTO getStep_7() {
        return step_7;
    }

    public StepDTO getStep_8() {
        return step_8;
    }

    public StepLichtDTO getStep_9() {
        return step_9;
    }

    public StepZubehoerDTO getStep_10() {
        return step_10;
    }

    public int getGesamtPreis() {
        return gesamtPreis;
    }

    /*** SETTER ***/
    public void setStep_1(StepRahmenFormTypDTO step_1) {
        this.step_1 = step_1;
    }

    public void setStep_2(StepDTO step_2) {
        this.step_2 = step_2;
    }

    public void setStep_3(StepRahmenFarbeHoehe step_3) { this.step_3 = step_3; }

    public void setStep_4(StepDTO step_4) {
        this.step_4 = step_4;
    }

    public void setStep_5(StepDTO step_5) {
        this.step_5 = step_5;
    }

    public void setStep_6(StepDTO step_6) {
        this.step_6 = step_6;
    }

    public void setStep_7(StepDTO step_7) {
        this.step_7 = step_7;
    }

    public void setStep_8(StepDTO step_8) {
        this.step_8 = step_8;
    }

    public void setStep_9(StepLichtDTO step_9) {
        this.step_9 = step_9;
    }

    public void setStep_10(StepZubehoerDTO step_10) {
        this.step_10 = step_10;
    }

    public void setGesamtPreis(int gesamtPreis) {
        this.gesamtPreis = gesamtPreis;
    }
}
