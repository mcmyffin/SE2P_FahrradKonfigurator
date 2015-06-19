package models.Mailer;

import play.data.validation.Constraints;
import play.libs.mailer.Email;
import play.libs.mailer.MailerPlugin;
import play.api.Play.*;

/**
 * Created by tin on 02.05.15.
 */
public class Mailer implements IMailer{
    @Override
    public boolean sendKontaktMail(String email, String betreff, String nachricht) {
        Email mail = new Email();
        mail.setSubject(betreff);
        mail.setFrom("FahrradKonfi-Kontakt FROM <"+ email +">");
        mail.addTo("<fahrradkonfigurator@gmail.com>");
        mail.setBodyText(nachricht);
        MailerPlugin.send(mail);
        return true;
    }

    public boolean sendEMailTo(String toEmail, String betreff, String nachricht){
        Email mail = new Email();
        mail.setSubject(betreff);
        mail.setFrom("Fahrradkonfigurator FROM <fahrradkonfigurator@gmail.com>");
        mail.addTo("<"+toEmail+">");
        mail.setBodyText(nachricht);
        MailerPlugin.send(mail);
        return true;
    }
}

