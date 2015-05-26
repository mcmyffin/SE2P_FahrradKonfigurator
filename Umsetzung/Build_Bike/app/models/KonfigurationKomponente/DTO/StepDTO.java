package models.KonfigurationKomponente.DTO;

/**
 * Created by dima on 25.05.15.
 */
public class StepDTO {

    private int id;
    private String einzelteileTyp;

    public StepDTO(int id,String einzelteileTyp){
        this.id = id;
        this.einzelteileTyp = einzelteileTyp;
    }

    /*** GETTER ***/
    public int getId() {
        return id;
    }

    public String getEinzelteileTyp() {
        return einzelteileTyp;
    }

    /*** SETTER ***/
    public void setId(int id) {
        this.id = id;
    }

    public void setEinzelteileTyp(String einzelteileTyp) {
        this.einzelteileTyp = einzelteileTyp;
    }
}
