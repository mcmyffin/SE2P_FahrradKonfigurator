package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import play.data.Form;

public class Application extends Controller {

    public boolean doSomething(){
        boolean iDidSomething = true;
        return iDidSomething;
    }

}
