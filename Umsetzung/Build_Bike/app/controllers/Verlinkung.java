package controllers;

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
        return ok(registrieren.render("Got it"));
    }

    public static Result step02() {
        return ok(step02.render());
    }

    public static Result step03() {
        return ok(step03.render());
    }

    public static Result step04() {
        return ok(step04.render());
    }

    public static Result step05() {
        return ok(step05.render());
    }

    public static Result step06() {
        return ok(step06.render());
    }

    public static Result step07() {
        return ok(step07.render());
    }

    public static Result step08() {
        return ok(step08.render());
    }

    public static Result step09() {
        return ok(step09.render());
    }

    public static Result bestellen() {
        return ok(bestellen.render());
    }

    public static Result warenkorb() {
        return ok(warenkorb.render());
    }

}
