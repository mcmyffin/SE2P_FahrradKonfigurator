package models.KonfigurationKomponente;

import models.Exception.UngueltigerStepException;
import models.KonfigurationKomponente.DTO.KonfigurationDTO;
import models.TeileKomponente.Einzelteile.*;

import java.util.List;

/**
 * Created by dima on 21.05.15.
 */
public interface IKofigurationKomponente {

    // step 2
    public List<Rahmen> filterRahmenByKonfiguration(IKonfiguration konfiguration, List<Rahmen> rahmenList) throws UngueltigerStepException;

    // step 3
    public List<String> getRahmenFarbenByKonfiguration(IKonfiguration konfiguration) throws UngueltigerStepException;
    public List<Integer> getRahmenHoehenByKonfiguration(IKonfiguration konfiguration) throws UngueltigerStepException;

    // step 4
    public List<Gabel> filterGabelByKonfiguration(IKonfiguration konfiguration, List<Gabel> gabelList) throws UngueltigerStepException;

    // step 5
    public List<Felge> filterFelgeByKonfiguration(IKonfiguration konfiguration, List<Felge> felgeList) throws UngueltigerStepException;

    // step 6
    public List<Mantel> filterMantelByKonfiguration(IKonfiguration konfiguration, List<Mantel> mantelList) throws UngueltigerStepException;

    // step 7
    public List<Vorbau> filterVorbauByKonfiguration(IKonfiguration konfiguration, List<Vorbau> vorbauList) throws UngueltigerStepException;

    // step 8
    public List<Sattel> filterSattelByKonfiguration(IKonfiguration konfiguration, List<Sattel> sattelList) throws UngueltigerStepException;

    // step 9
    public boolean filterFestlicht(IKonfiguration konfiguration) throws UngueltigerStepException;

    // step 10
    public List<Zubehoer> filterZubehoerByKonfiguration(IKonfiguration konfiguration, List<Zubehoer> zubehoerList) throws UngueltigerStepException;


    public IKonfiguration fromKonfigurtionDTO(KonfigurationDTO konfigurationDTO);

}
