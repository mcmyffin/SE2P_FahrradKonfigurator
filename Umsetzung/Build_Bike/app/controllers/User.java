package controllers;

import models.Kunde.IKunde;
import models.Kunde.Kunde;
import models.Mailer.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

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

    public static Result mail(){
        DynamicForm mailData = Form.form().bindFromRequest();
        String emailKunde = "testmail@knfitest1234.konfi"; //mailData.get("");
        String emailBetreff = "testauf funzt"; //mailData.get("");
        String emailNachricht = "haltsmaul"; //mailData.get("");
        IMailer kontaktMailer = new Mailer();
        kontaktMailer.sendKontaktMail(emailKunde,emailBetreff,emailNachricht);
        return ok(kontakt.render("<div class=\"success\">Deine Anfrage wurde gesendet.</div>"));
    }

    public static Result logout(){
        // todo
        return null;
    }
}
