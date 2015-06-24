package controllers;

import models.DatenTypen.Pair;
import models.Exception.UngueltigerStepException;
import models.KonfigurationKomponente.IKonfiguration;
import models.TeileKomponente.DTO.EinzelteilDTO;
import models.TeileKomponente.Einzelteile.Mantel;
import models.TeileKomponente.ITeileKomponente;
import models.TeileKomponente.TeileKomponente;
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

        List<EinzelteilDTO> rahmenliste = null;
        try {
            rahmenliste = KonfigurationsSchritte.getRahmenListe();
        } catch (UngueltigerStepException e) {
            return ok(konfigurator.render());
        }

        return ok(step02.render(rahmenliste));
    }

    public static Result step03() {

        Pair<List<String>,List<Integer>> rahmenFarbeHoehe = null;
        EinzelteilDTO rahmen = null;

        try {
            rahmenFarbeHoehe = KonfigurationsSchritte.getRahmenFarbeHoehe();

            ITeileKomponente teileKomponente = new TeileKomponente();
            IKonfiguration konfiguration = KonfigurationSession.getKonfigurationFromSession();
            rahmen = teileKomponente.toEinzelteilDTO(konfiguration.getStep2().getRahmen());

        } catch (UngueltigerStepException e) {
            return step02();
        }

        return ok(step03.render(rahmenFarbeHoehe,rahmen));
    }

    public static Result step04() {

        List<EinzelteilDTO> gabelListe = null;
        try {
            gabelListe = KonfigurationsSchritte.getFahrradGabelList();
        } catch (UngueltigerStepException e) {
            return step03();
        }

        return ok(step04.render(gabelListe));
    }

    public static Result step05() {

        List<EinzelteilDTO> felgeListe = null;
        try {
            felgeListe = KonfigurationsSchritte.getFelgeList();
        } catch (UngueltigerStepException e) {
            return step04();
        }

        return ok(step05.render(felgeListe));
    }

    public static Result step06() {

        List<EinzelteilDTO> mantelList = null;
        try {
            mantelList = KonfigurationsSchritte.getMantelList();
        } catch (UngueltigerStepException e) {
            return step05();
        }
        return ok(step06.render(mantelList));
    }

    public static Result step07() {

        List<EinzelteilDTO> vorbauList = null;
        try {
            vorbauList = KonfigurationsSchritte.getVorbauList();
        } catch (UngueltigerStepException e) {
            return step06();
        }
        return ok(step07.render(vorbauList));
    }

    public static Result step08() {

        List<EinzelteilDTO> sattelList = null;
        try {
            sattelList = KonfigurationsSchritte.getSattelList();
        } catch (UngueltigerStepException e) {
            return step07();
        }
        return ok(step08.render(sattelList));
    }

    public static Result step09() {

        Boolean isFestLicht = null;
        try {
            isFestLicht = KonfigurationsSchritte.getBeleuchtung();
        } catch (UngueltigerStepException e) {
            return step08();
        }
        return ok(step09.render(isFestLicht));
    }

    public static Result step10() {

        List<EinzelteilDTO> zubehoerListe = null;
        try {
            zubehoerListe = KonfigurationsSchritte.getZubehoerList();
        } catch (UngueltigerStepException e) {
            return step09();
        }
        return ok(step10.render(zubehoerListe));
    }

    public static Result bestellen() {
        return ok(bestellen.render());
    }

    public static Result warenkorb() {
        return ok(warenkorb.render());
    }

}
