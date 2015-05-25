package models.KonfigurationKomponente;

import models.TeileKomponente.Einzelteile.*;

import java.util.List;

/**
 * Created by dima on 24.05.15.
 */
public class KonfigurationKomponente implements IKofigurationKomponente {


    @Override
    public List<Felge> filterFelgeByKonfiguration(IKonfiguration konfiguration, List<Felge> felgeList) {
        return null;
    }

    @Override
    public List<Gabel> filterGabelByKonfiguration(IKonfiguration konfiguration, List<Gabel> gabelList) {
        return null;
    }

    @Override
    public List<Mantel> filterMantelByKonfiguration(IKonfiguration konfiguration, List<Mantel> mantelList) {
        return null;
    }

    @Override
    public List<Sattel> filterSattelByKonfiguration(IKonfiguration konfiguration, List<Sattel> sattelList) {
        return null;
    }

    @Override
    public List<Rahmen> filterRahmenByKonfiguration(IKonfiguration konfiguration, List<Rahmen> rahmenList) {
        return null;
    }

    @Override
    public List<Vorbau> filterVorbauByKonfiguration(IKonfiguration konfiguration, List<Vorbau> vorbauList) {
        return null;
    }

    @Override
    public List<Zubehoer> filterZubehoerByKonfiguration(IKonfiguration konfiguration, List<Zubehoer> zubehoerList) {
        return null;
    }
}
