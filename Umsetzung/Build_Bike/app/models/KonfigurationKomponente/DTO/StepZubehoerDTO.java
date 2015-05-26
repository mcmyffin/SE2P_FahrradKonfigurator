package models.KonfigurationKomponente.DTO;

import java.util.List;

/**
 * Created by dima on 25.05.15.
 */
public class StepZubehoerDTO {

    private List<Integer> zubehoerListe;
    private String einzelteileTyp;

    public StepZubehoerDTO(List<Integer> zubehoerListe, String einzelteileTyp) {
        this.zubehoerListe = zubehoerListe;
        this.einzelteileTyp = einzelteileTyp;
    }

    /*** GETTER ***/
    public List<Integer> getZubehoerListe() {
        return zubehoerListe;
    }

    public String getEinzelteileTyp() {
        return einzelteileTyp;
    }

    /*** SETTER ***/
    public void setZubehoerListe(List<Integer> zubehoerListe) {
        this.zubehoerListe = zubehoerListe;
    }

    public void setEinzelteileTyp(String einzelteileTyp) {
        this.einzelteileTyp = einzelteileTyp;
    }
}
