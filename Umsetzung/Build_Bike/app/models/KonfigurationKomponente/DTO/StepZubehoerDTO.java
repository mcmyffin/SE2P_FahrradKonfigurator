package models.KonfigurationKomponente.DTO;

import java.util.*;

/**
 * Created by dima on 25.05.15.
 */
public class StepZubehoerDTO {

    private int[] zubehoerListe;
    private String einzelteileTyp;

    public StepZubehoerDTO(){};

    public StepZubehoerDTO(List<Integer> zubehoerListe, String einzelteileTyp) {
        this.zubehoerListe = parseList(zubehoerListe);
        this.einzelteileTyp = einzelteileTyp;
    }

    private int[] parseList(List<Integer> list){

        int[] ergebnis = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            ergebnis[i] = list.get(i);
        }
        return ergebnis;
    }

    /*** GETTER ***/
    public int[] getZubehoerListe() {
        return zubehoerListe;
    }

    public String getEinzelteileTyp() {
        return einzelteileTyp;
    }

    /*** SETTER ***/
    public void setZubehoerListe(int[] zubehoerListe) {
        this.zubehoerListe = zubehoerListe;
    }

    public void setEinzelteileTyp(String einzelteileTyp) {
        this.einzelteileTyp = einzelteileTyp;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null) return false;
        if(this == obj) return true;
        if(!(obj instanceof StepZubehoerDTO)) return false;
        StepZubehoerDTO aStep = (StepZubehoerDTO) obj;

        if(this.getEinzelteileTyp().equals(aStep.einzelteileTyp)){

            boolean length = this.getZubehoerListe().length == aStep.getZubehoerListe().length;
            if(length){

                for(int i = 0; i < this.getZubehoerListe().length; i++){
                    boolean same = (this.getZubehoerListe()[i] == aStep.getZubehoerListe()[i]);
                    if(!same) return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
