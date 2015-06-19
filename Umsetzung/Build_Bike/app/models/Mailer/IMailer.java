package models.Mailer;

/**
 * Created by tin on 02.05.15.
 */
public interface IMailer {

    /**
     * Methode zum versenden einer Email an unseren E-Mailkontakt server
     * @param email e-Mail, an die gesendet werden soll
     * @param betreff Betreff der e-Mail
     * @param nachricht die Nachricht
     * @return Erfolgreich --> true;
     */
    public boolean sendKontaktMail(String email, String betreff, String nachricht);

    public boolean sendEMailTo(String toEmail, String betreff, String nachricht);
}
