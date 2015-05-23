package models.KonfigurationKomponente;

/**
 * Created by dima on 21.05.15.
 */
public interface IKofigurationKomponente {

    // TODO step 1 TYP
    public IKonfiguration setRahmenTyp(int rahmenID);

    // TODO step 2 FARBE
    public boolean setRahmenFarbe(IKonfiguration konf);

    // TODO step 3 RAHMENGROESSE
    public boolean setRahmenGroesse(IKonfiguration konf);

    // TODO step 4 FAHRRADGABEL
    public boolean setFahrradGabel(IKonfiguration konf);

    // TODO step 5 REIFEN (unplattbar?)
    public boolean setReifen(IKonfiguration konf, boolean isUnplattbar);

    // TODO step 6 SchaltungsTyp
    public boolean setSchaltungsTyp(IKonfiguration konf);

    // TODO step 7 Sattel
    public boolean setSattel(IKonfiguration konf);

    // TODO step 8 Beleuchtung/Art
    public boolean setBeleuchtung(IKonfiguration konf);

    // TODO step 9 Zubehoer(Fahrradhelm, Fahrradschloss, Fahrradpumpe, Fahrradklingel)
    public boolean setZubehoer(IKonfiguration konf);



}
