package models.Kunde;

/**
 * Created by tin on 01.05.15.
 */
public interface IKundenKomponente {

    /**
     * !!! NOTIZ, Datentypen müssen noch implementiert werden !!!
     * Anmelden
     * Eine Anmeldung erfolgt mit der email-Adresse und dem Passwort
     *
     * @param email
     * @param passwort
     *
     * @return true wenn eine Anmeldung erfolgreich war, sonst false
     */
    public boolean anmelden(String email, String passwort);


    /**
     * !!! NOTIZ, Datentypen müssen noch implementiert werden !!!
     * Registrieren
     * Registriert den User als Kunden mit den aufgelisteten Parametern
     *
     * @param email
     * @param passwort
     * @param vorname
     * @param nachname
     * @param gebDatum
     * @param telefonNr
     * @param strasse
     * @param hausnummer
     * @param adressZs
     * @param plz
     * @param stadt
     *
     * Legende:
     *      -1 = Kunde mit der Email Adresse existiert bereits
     *       0 = Registrierung war erfolgreich
     *       1 = Registrierung war nicht erfolgreich, da fehlerhafte Eingabe
     *       2 = Registrierung zurzeit nicht möglich
     *       ...
     *
     * @return
     */
    public int registrieren(String email, String passwort, String vorname, String nachname, String gebDatum, String telefonNr,
                                String strasse, int hausnummer, String adressZs, int plz, String stadt);
}
