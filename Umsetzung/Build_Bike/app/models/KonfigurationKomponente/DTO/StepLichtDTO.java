package models.KonfigurationKomponente.DTO;

/**
 * Created by dima on 25.05.15.
 */
public class StepLichtDTO {

    private boolean isGefragt = false;
    private boolean isSteckLicht = false;
    private boolean isFestLicht = false;


    public StepLichtDTO(boolean isGefragt, boolean isSteckLicht, boolean isFestLicht) {
        this.isGefragt = isGefragt;
        this.isSteckLicht = isSteckLicht;
        this.isFestLicht = isFestLicht;
    }

    /*** GETTER ***/
    public boolean isGefragt() {
        return isGefragt;
    }

    public boolean isSteckLicht() {
        return isSteckLicht;
    }

    public boolean isFestLicht() {
        return isFestLicht;
    }

    /*** SETTER ***/
    public void setIsGefragt(boolean isGefragt) {
        this.isGefragt = isGefragt;
    }

    public void setIsSteckLicht(boolean isSteckLicht) {
        this.isSteckLicht = isSteckLicht;
    }

    public void setIsFestLicht(boolean isFestLicht) {
        this.isFestLicht = isFestLicht;
    }
}
