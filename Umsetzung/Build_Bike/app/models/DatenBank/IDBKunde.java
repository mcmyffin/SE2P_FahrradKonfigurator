package models.DatenBank;

import models.Exception.DatabaseException;

import java.util.List;

/**
 * Created by tin on 01.05.15.
 */
public interface IDBKunde {
    /**
* Methode zum prüfen ob die Emailadresse enthalten ist
* @param mailadr Emailadresse
* @result vorhanden -> true
* */
    public boolean isKundeExistByMail(String mailadr) throws DatabaseException;


    /**
    * Methode zum erhalten von einen Kunden aus der DB
    * @param id id vom Kunden
    * @result KundenKomponente
    * */
    public List<String> getKundeByID(int id) throws DatabaseException;


    /**
    * Methode zum erhalten der ID des Kunden
    * @param mail Emailadresse des Kunden
    * @param pass passwort des Kunden
    * @result id des Kunden
    * */
    public int getKundeIDByLogin(String mail, String pass) throws DatabaseException;


    /**
    * Methode zum erhaltne der adresse des Kunden
    * @param id ID des Kunden
    * @result Adresse des Kunden
    *
    * */
    public List<String> getAdressByID(int id) throws DatabaseException;


    /**
    * Methode zum setzen eines neuen Vornamens
    * @param id ID des Kunden
    * @param vorname neuer Vorname
    * @result Erfolg -> true
    * */
    public boolean setVorname(int id, String vorname) throws DatabaseException;


    /**
    * Methode zum setzen eines neune Nachnamens
    * @param id ID des Kunden
    * @param nachname Neuer nachname des Kunden
    * @result Erfolg -> true
    *
    * */
    public boolean setNachname(int id, String nachname) throws DatabaseException;


    /**
    * Methode zum setzen einer neuen Adresse
    * @param id ID des Kunden
    * @param adresse Neue adresse des Kunden
    * @result Erfolg -> true
    * */
    public boolean setAdresse(int id, List<String> adresse) throws DatabaseException;


    /**
    * Methode zum setzen einer neuen Emailadresse
    * @param id ID des Kunden
    * @param email Neue Emailadresse des Kunden
    * @result Erfolg -> true
    * */
    public boolean setEMail(int id, String email) throws DatabaseException;


    /**
    * Methode zum wechseln des Passwortes
    * @param id ID des Kunden
    * @param passwort Neues Passwort des Kunden
    * @result Erfolg -> true
    *
    * */
    public boolean setPasswort(int id, String passwort) throws DatabaseException;

    /**
     * Methode zum neuregistrieren eines Kunden
     * @param email emailadresse des Kunden
     * @param passwort Passwort des neuen Kunden
     * @param vorname vorname des Kunden
     * @param nachname Nachname des Kunden
     * @param telefonnummer Telefonnummer des Kunden
     * @param strasse Straße, wo der KundenKomponente wohnt
     * @param hausnummer Hausnummer des kunden
     * @param adresszusatz Adresszusatz vom Kunden
     * @param plz Plz der Stadt des Kunden
     * @param stadt Stadt des Kunden
     * @return Erfolgreich eingetragen -> True
     */
    public boolean setNeuerKunde(String email, String passwort, String vorname, String nachname, String gebDatum,
                                 String telefonnummer, String strasse, int hausnummer, String adresszusatz,
                                 int plz, String stadt) throws DatabaseException;
}
