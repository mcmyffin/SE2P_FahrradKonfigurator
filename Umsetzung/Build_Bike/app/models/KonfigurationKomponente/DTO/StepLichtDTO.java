package models.KonfigurationKomponente.DTO;

/**
 * Created by dima on 25.05.15.
 */
public class StepLichtDTO {

    private int gefragt = 0;
    private int steckLicht = 0;
    private int festLicht = 0;


    public StepLichtDTO(){};

    public StepLichtDTO(int isGefragt, int isSteckLicht, int isFestLicht) {
        this.gefragt = isGefragt;
        this.steckLicht = isSteckLicht;
        this.festLicht = isFestLicht;
    }

    /*** GETTER ***/
    public int getGefragt() {
        return gefragt;
    }

    public int getSteckLicht() {
        return steckLicht;
    }

    public int getFestLicht() {
        return festLicht;
    }

    /*** SETTER ***/
    public void setGefragt(int gefragt) {
        this.gefragt = gefragt;
    }

    public void setSteckLicht(int steckLicht) {
        this.steckLicht = steckLicht;
    }

    public void setFestLicht(int festLicht) {
        this.festLicht = festLicht;
    }

    @Override
    public String toString() {
        return "StepLichtDTO{gefragt:"+ gefragt +", steckLicht:"+ steckLicht +",festLicht:"+ festLicht +"}";
    }
}
