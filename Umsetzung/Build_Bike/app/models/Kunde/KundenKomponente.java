package models.Kunde;

import models.DatenBank.DataC;
import models.DatenBank.IDatenBank;

/**
 * Created by tin on 01.05.15.
 */
public class KundenKomponente implements IKundenKomponente {
    IDatenBank _db;

    public KundenKomponente(){

        this._db = new DataC();
    }

    @Override
    public boolean anmelden(String email, String pw) {

        if(_db.isKundeExistByMail(email)){
            return (_db.getKundeIDByLogin(email,pw) == 0 ? false : true);
        }
        return false;
    }

    @Override
    public int registrieren(String email, String passwort, String vorname, String nachname, String gebDatum, String telefonNr,
                            String strasse, int hausnummer, String adressZs, int plz, String stadt) {

        // precondition
        boolean sindEingabenLeer = email.isEmpty() && passwort.isEmpty() && vorname.isEmpty() && nachname.isEmpty() &&
                                   gebDatum.isEmpty() && strasse.isEmpty() && stadt.isEmpty();

        boolean sindEingabenUndefiniert = email == null && passwort == null && vorname == null && nachname == null &&
                                          gebDatum == null && stadt == null;

        // prüfe auf leere und undefinierte Eingaben
        if(sindEingabenLeer || sindEingabenUndefiniert) return 1;

        // prüfe auf vorhandene E-Mail Adresse
        if(_db.isKundeExistByMail(email)) return -1;

        // Adresszusatz darf leer sein. Man muss ueberpfruefen ob dieser nicht null ist
        adressZs = (adressZs == null ? "" : adressZs);

        if(_db.setNeuerKunde(email,passwort,vorname,nachname,gebDatum,telefonNr,strasse,hausnummer,adressZs,plz,stadt)){
            return 0;
        }else{
            return 2;
        }




    }
}
