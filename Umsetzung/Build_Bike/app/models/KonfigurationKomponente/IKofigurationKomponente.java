package models.KonfigurationKomponente;

import models.KonfigurationKomponente.DTO.KonfigurationDTO;
import models.TeileKomponente.Einzelteile.*;

import java.util.List;

/**
 * Created by dima on 21.05.15.
 */
public interface IKofigurationKomponente {

    public List<Felge> filterFelgeByKonfiguration(IKonfiguration konfiguration, List<Felge> felgeList);

    public List<Gabel> filterGabelByKonfiguration(IKonfiguration konfiguration, List<Gabel> gabelList);

    public List<Mantel> filterMantelByKonfiguration(IKonfiguration konfiguration, List<Mantel> mantelList);

    public List<Sattel> filterSattelByKonfiguration(IKonfiguration konfiguration, List<Sattel> sattelList);

    public List<Rahmen> filterRahmenByKonfiguration(IKonfiguration konfiguration, List<Rahmen> rahmenList);

    public List<Vorbau> filterVorbauByKonfiguration(IKonfiguration konfiguration, List<Vorbau> vorbauList);

    public List<Zubehoer> filterZubehoerByKonfiguration(IKonfiguration konfiguration, List<Zubehoer> zubehoerList);

    public List<String> getRahmenFarbenByKonfiguration(IKonfiguration konfiguration);

    public List<Integer> getRahmenHoehenByKonfiguration(IKonfiguration konfiguration);

    public IKonfiguration fromKonfigurtionDTO(KonfigurationDTO konfigurationDTO);

    /*****************/
    // TODO step 1 TYP

    // TODO step 2 FARBE

    // TODO step 3 RAHMENGROESSE

    // TODO step 4 FAHRRADGABEL

    // TODO step 5 REIFEN (unplattbar?)

    // TODO step 6 SchaltungsTyp

    // TODO step 7 Sattel

    // TODO step 8 Beleuchtung/Art

    // TODO step 9 Zubehoer(Fahrradhelm, Fahrradschloss, Fahrradpumpe, Fahrradklingel)

}
