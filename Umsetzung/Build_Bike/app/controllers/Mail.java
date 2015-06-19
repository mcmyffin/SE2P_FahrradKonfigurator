package controllers;

import models.Mailer.IMailer;
import models.Mailer.Mailer;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.kontakt;

/**
 * Created by tin on 02.05.15.
 */
public class Mail extends Controller {

    public static Result kontaktMail(){
        DynamicForm mailData = Form.form().bindFromRequest();
        String emailKunde = mailData.get("email");
        String emailBetreff = mailData.get("subject");
        String emailNachricht = mailData.get("message");
        emailNachricht = "Email des Mitteilungsbedürftigen: "+emailKunde+"\n"+
                "Name des Mitteilungsbedürftigen: " + mailData.get("name") +
                "\n"+ "Nummer des Mitteilungsbedürftigen: "+ mailData.get("phone") + "\n" + emailNachricht;
        IMailer kontaktMailer = new Mailer();
        kontaktMailer.sendKontaktMail(emailKunde,emailBetreff,emailNachricht);
        return ok(kontakt.render("<div class=\"success\">Deine Anfrage wurde gesendet.</div>"));
    }

    public static Result sendeEmailZumKunden(){
        DynamicForm mailData = Form.form().bindFromRequest();
        String emailKunde = mailData.get("email");
        String emailBetreff = "Dein bestelltes Fahrrad von Fahrradkonfigurator :D";
        String emailNachricht = "Hihihihihi du bekommst ein Fahrrad von uns :).\n Denkste! wird nischts, HAHA";
        IMailer eMailZumKunden = new Mailer();
        eMailZumKunden.sendEMailTo(emailKunde,emailBetreff,emailNachricht);
        return ok(index.render());
    }
}
