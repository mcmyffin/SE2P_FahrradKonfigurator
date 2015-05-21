package models.Mailer;

import play.libs.mailer.Email;
import play.libs.mailer.MailerPlugin;
import play.api.Play.*;

/**
 * Created by tin on 02.05.15.
 */
public class Mailer implements IMailer {
    @Override
    public boolean sendKontaktMail(String email, String betreff, String nachricht) {
        Email mail = new Email();
        mail.setSubject(betreff);
        mail.setFrom("FahrradKonfi-Kontakt FROM <"+ email +">");
        mail.addTo("<"+ "tinmad17@gmail.com" +">");
        mail.setBodyText(nachricht);
        MailerPlugin.send(mail);
        return true;
    }
}
