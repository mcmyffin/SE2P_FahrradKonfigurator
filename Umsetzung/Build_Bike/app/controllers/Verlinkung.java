package controllers;

import models.DatenTypen.Pair;
import models.KonfigurationKomponente.IKonfiguration;
import models.TeileKomponente.DTO.EinzelteilDTO;
import models.TeileKomponente.Einzelteile.Mantel;
import models.WarenkorbKomponente.DTO.WarenkorbDTO;
import play.*;
import play.mvc.*;

import views.html.*;

import play.data.Form;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tin on 27.04.15.
 */
public class Verlinkung extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result account() {
        return ok(account.render());
    }

    public static Result agb() {
        return ok(agb.render());
    }

    public static Result impressum() {
        return ok(impressum.render());
    }

    public static Result konfigurator() {
        return ok(konfigurator.render());
    }

    public static Result kontakt() {
        return ok(kontakt.render(null));
    }

    public static Result login() {

        if(User.prufeUserSession()) return ok(account.render());

        return ok(login.render(null));
    }

    public static Result registrieren() {
        return ok(registrieren.render(null));
    }

    public static Result step02() {

        List<EinzelteilDTO> rahmenliste = KonfigurationsSchritte.getRahmenListe();

        return ok(step02.render(rahmenliste));
    }

    public static Result step03() {

        Pair<List<String>,List<Integer>> rahmenFarbeHoehe = KonfigurationsSchritte.getRahmenFarbeHoehe();

        return ok(step03.render(rahmenFarbeHoehe));
    }

    public static Result step04() {

        List<EinzelteilDTO> gabelListe = KonfigurationsSchritte.getFahrradGabelList();

        return ok(step04.render(gabelListe));
    }

    public static Result step05() {

        List<EinzelteilDTO> felgeListe = KonfigurationsSchritte.getFelgeList();

        return ok(step05.render(felgeListe));
    }

    public static Result step06() {

        List<EinzelteilDTO> mantelList = KonfigurationsSchritte.getMantelList();
        return ok(step06.render(mantelList));
    }

    public static Result step07() {

        List<EinzelteilDTO> vorbauList = KonfigurationsSchritte.getVorbauList();
        return ok(step07.render(vorbauList));
    }

    public static Result step08() {

        List<EinzelteilDTO> sattelList = KonfigurationsSchritte.getSattelList();
        return ok(step08.render(sattelList));
    }

    public static Result step09() {

        Boolean isFestLicht = KonfigurationsSchritte.getBeleuchtung();
        return ok(step09.render(isFestLicht));
    }

    public static Result step10() {

        List<EinzelteilDTO> zubehoerListe = KonfigurationsSchritte.getZubehoerList();
        return ok(step10.render(zubehoerListe));
    }

    public static Result bestellen() {
        return ok(bestellen.render());
    }

    public static Result warenkorb() {
        return ok(warenkorb.render());
    }

}
