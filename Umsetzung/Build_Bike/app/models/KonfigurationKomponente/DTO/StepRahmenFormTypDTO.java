package models.KonfigurationKomponente.DTO;

/**
 * Created by dima on 25.05.15.
 */
public class StepRahmenFormTypDTO {

    private String rahmenFormTyp;

    public StepRahmenFormTypDTO(){};

    public StepRahmenFormTypDTO(String rahmenFormTyp) {
        this.rahmenFormTyp = rahmenFormTyp;
    }

    public String getRahmenFormTyp() {
        return rahmenFormTyp;
    }

    public void setRahmenFormTyp(String rahmenFormTyp) {
        this.rahmenFormTyp = rahmenFormTyp;
    }
}
