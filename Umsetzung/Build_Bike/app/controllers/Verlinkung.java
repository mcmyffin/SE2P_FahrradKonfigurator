package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import play.data.Form;

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
        return ok(kontakt.render());
    }

    public static Result login() {
        return ok(login.render());
    }

    public static Result registrieren() {
        return ok(registrieren.render());
    }

    public static Result step02() {
        return ok(step02.render());
    }

    public static Result warenkorb() {
        return ok(warenkorb.render());
    }

}
