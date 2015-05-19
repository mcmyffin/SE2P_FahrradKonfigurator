package controllers;

import models.Kunde.IKundenKomponente;
import models.Kunde.KundenKomponente;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

/**
 * Created by dima on 29.04.15.
 */
public class User extends Controller {


    public static final String USER = "user";
    public static final String TIME = "time";


    public static boolean prufeUserSession(){

        return (session(USER) != null);
    }

    public static Result anmelden(){

        DynamicForm loginData = Form.form().bindFromRequest();

        String email = loginData.get("username");
        String passwort = loginData.get("password");

        IKundenKomponente kunde = new KundenKomponente();
        boolean loginResult = kunde.anmelden(email, passwort);

        // setzte Session
        if(loginResult){
            session(USER,email);
            session(TIME,Long.toString(System.currentTimeMillis()));
        }

        return ok(account.render());
    }

    public static Result registrieren(){

        DynamicForm registrierenData = Form.form().bindFromRequest();

        // Kunde
        String email = registrierenData.get("email");
        String passwort= registrierenData.get("passwort");
        String vorname = registrierenData.get("vorname");
        String nachname = registrierenData.get("nachname");
        String gebDatum = registrierenData.get("gebDatum");
        String telefonNr = registrierenData.get("telefonNr");
        // !!! FEHLT DAS GEBURTSDATUM !!!

        // Adresse
        String strasse = registrierenData.get("strasse");
        String hausNr = registrierenData.get("hausNr");
        String adressZs = registrierenData.get("adressZs");
        String plz = registrierenData.get("plz");
        String stadt = registrierenData.get("stadt");

        // -1 = email schon registriert
        //  0 = erfolgreich registriert
        //  1 = fehlerhafte Eingabe
        //  2 = Registrieren zurzeit nicht möglich
        String statusMeldung = "Registrierung zurzeit nicht möglich";

        // Typ umwandeln
        try {
            int hNr = Integer.parseInt(hausNr);
            int postLeitZahl = Integer.parseInt(plz);


            IKundenKomponente kKomponente = new KundenKomponente();
            int bericht = kKomponente.registrieren(email,passwort,vorname,nachname,gebDatum,telefonNr,strasse,hNr,adressZs,postLeitZahl,stadt);

            if(bericht == -1){
                statusMeldung = "diese E-Mail Adresse ist bereits vergeben";
            }else if(bericht == 0) {
                statusMeldung = "erfolgreich registriert";
            }
        } catch (Exception e){
            statusMeldung = "ueberpruefen Sie die Eingaben";
        }

        return ok(registrieren.render(statusMeldung));
    }

    public static Result logout(){
        session().remove(USER);
        session().remove(TIME);
        return redirect("/login");
    }
}
