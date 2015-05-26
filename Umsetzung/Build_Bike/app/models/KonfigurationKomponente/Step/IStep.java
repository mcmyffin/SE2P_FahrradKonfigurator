package models.KonfigurationKomponente.Step;

import models.TeileKomponente.EinzelTeileTyp;
import models.TeileKomponente.Einzelteile.*;
import models.TeileKomponente.RahmenFormTyp;

import java.util.List;

/**
 * Created by dima on 24.05.15.
 */
public interface IStep extends IStep_1, IStep_2, IStep_3, IStep_4, IStep_5, IStep_6, IStep_7, IStep_8, IStep_9 {

    public void setRahmenFormTyp(RahmenFormTyp rahmenFormTyp);

    public void setRahmen(Rahmen rahmen);

    public void setGabel(Gabel gabel);

    public void setFelge(Felge felge);

    public void setMantel(Mantel mantel);

    public void setVorbau(Vorbau vorbau);

    public void setSattel(Sattel sattel);

    public void setLicht(boolean isGefragt, boolean isSteckLicht, boolean isFestlicht);

    public void setZubehoerList(List<Zubehoer> zubehoerList);
}
