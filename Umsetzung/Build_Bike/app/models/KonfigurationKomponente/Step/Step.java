package models.KonfigurationKomponente.Step;

/**
 * Created by dima on 24.05.15.
 */
public class Step implements IStep{

    private int stepNummer = 0;


    @Override
    public int getStepNummer() {
        return this.stepNummer;
    }
}
