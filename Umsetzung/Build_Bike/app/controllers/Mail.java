package controllers;

import models.Mailer.IMailer;
import models.Mailer.Mailer;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
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
        emailNachricht = "Name des Mitteilungsbedürftigen: " + mailData.get("name") +
                "\n"+ "Nummer des Mitteilungsbedürftigen: "+ mailData.get("phone") + "\n" + emailNachricht;
        IMailer kontaktMailer = new Mailer();
        kontaktMailer.sendKontaktMail(emailKunde,emailBetreff,emailNachricht);
        return ok(kontakt.render("<div class=\"success\">Deine Anfrage wurde gesendet.</div>"));
    }
}
