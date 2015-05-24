package models.TeileKomponente;

import models.TeileKomponente.DTO.EinzelteilDTO;
import models.TeileKomponente.Einzelteile.*;

/**
 * Created by dima on 19.05.15.
 */
public interface ITeileKomponente {


    public EinzelteilDTO toEinzelteilDTO(Felge felge);

    public EinzelteilDTO toEinzelteilDTO(Gabel gabel);

    public EinzelteilDTO toEinzelteilDTO(Mantel mantel);

    public EinzelteilDTO toEinzelteilDTO(Rahmen rahmen);

    public EinzelteilDTO toEinzelteilDTO(Sattel sattel);

    public EinzelteilDTO toEinzelteilDTO(Vorbau vorbau);

    public EinzelteilDTO toEinzelteilDTO(Zubehoer zubehoer);

}
