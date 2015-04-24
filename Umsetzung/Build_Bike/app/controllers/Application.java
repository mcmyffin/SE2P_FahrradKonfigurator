package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import play.data.Form;

public class Application extends Controller {

public static Result index() {
        return ok(index.render());
    }

}
