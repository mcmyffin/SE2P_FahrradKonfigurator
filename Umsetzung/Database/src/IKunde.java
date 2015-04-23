import java.util.List;

/**
 * Created by tin on 07.04.15.
 */
public interface IKunde extends IDatabase {
    /*
    * Methode zum prüfen ob die Emailadresse enthalten ist
    * @param mailadr Emailadresse
    * @result vorhanden -> true
    * */
    public boolean isKundeExistByMail(String mailadr);


    /*
    * Methode zum erhalten von einen Kunden aus der DB
    * @param id id vom Kunden
    * @result Kunde
    * */
    public List<String> getKundeByID(int id);


    /*
    * Methode zum erhalten der ID des Kunden
    * @param mail Emailadresse des Kunden
    * @param pass passwort des Kunden
    * @result id des Kunden
    * */
    public int getKundeIDByLogin(String mail, String pass);


    /*
    * Methode zum erhaltne der adresse des Kunden
    * @param id ID des Kunden
    * @result Adresse des Kunden
    *
    * */
    public List<String> getAdressByID(int id);


    /*
    * Methode zum setzen eines neuen Vornamens
    * @param id ID des Kunden
    * @param vorname neuer Vorname
    * @result Erfolg -> true
    * */
    public boolean setVorname(int id, String vorname);


    /*
    * Methode zum setzen eines neune Nachnamens
    * @param id ID des Kunden
    * @param nachname Neuer nachname des Kunden
    * @result Erfolg -> true
    *
    * */
    public boolean setNachname(int id, String nachname);


    /*
    * Methode zum setzen einer neuen Adresse
    * @param id ID des Kunden
    * @param adresse Neue adresse des Kunden
    * @result Erfolg -> true
    * */
    public boolean setAdresse(int id, List<String> adresse);


    /*
    * Methode zum setzen einer neuen Emailadresse
    * @param id ID des Kunden
    * @param email Neue Emailadresse des Kunden
    * @result Erfolg -> true
    * */
    public boolean setEMail(int id, String email);


    /*
    * Methode zum wechseln des Passwortes
    * @param id ID des Kunden
    * @param passwort Neues Passwort des Kunden
    * @result Erfolg -> true
    *
    * */
    public boolean setPasswort(int id, String passwort);

}
