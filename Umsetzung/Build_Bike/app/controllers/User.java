package controllers;

import models.Kunde.IKunde;
import models.Kunde.Kunde;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.Map;

/**
 * Created by dima on 29.04.15.
 */
public class User extends Controller {


    public static Result login(){
        DynamicForm loginData = Form.form().bindFromRequest();
        String username = loginData.get("username");
        String password = loginData.get("password");
        String result = "BN: "+username+" PW: "+password;
        IKunde kunde = new Kunde();
        return ok(login.render(kunde.login(username,password)+""));
    }

    public static Result logout(){
        // todo
        return null;
    }
}
