package models.KonfigurationKomponente.DTO;

/**
 * Created by dima on 25.05.15.
 */
public class StepRahmenFarbeHoehe {

    private String rahmenfarbe;
    private int rahmenhoehe;

    public StepRahmenFarbeHoehe(){};

    public StepRahmenFarbeHoehe(String rahmenfarbe, int rahmenhoehe){
        this.rahmenfarbe = rahmenfarbe;
        this.rahmenhoehe = rahmenhoehe;
    }

    /*** GETTER ***/
    public String getRamenfarbe() {
        return rahmenfarbe;
    }

    public int getRahmenhoehe() {
        return rahmenhoehe;
    }

    /*** SETTER ***/
    public void setRamenfarbe(String ramenfarbe) {
        this.rahmenfarbe = ramenfarbe;
    }

    public void setRahmenhoehe(int rahmenhoehe) {
        this.rahmenhoehe = rahmenhoehe;
    }
}
