package models.DatenBank;


import org.mariadb.jdbc.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import play.db.*;

/**
 * Created by tin on 01.05.15.
 */
public class DataC implements IDatenBank {
    Connection _con = DB.getConnection();

    @Override
    public boolean isKundeExistByMail(String mailadr) {
        try {
            Statement stmt = _con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT K_email from KundeT where K_email = '" + mailadr + "';");
            stmt.close();
            while (rs.next()){
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public List<String> getKundeByID(int id) {
        List<String> kudArr = new ArrayList<String>();
        try {
            Statement stmt = _con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT K_adresse, K_email, K_nachname, K_telefon, K_vorname from KundeT where K_ID ="+id+";");
            stmt.close();
            while (rs.next()){
                kudArr.add(rs.getString("K_adresse"));
                kudArr.add(rs.getString("K_email"));
                kudArr.add(rs.getString("K_nachname"));
                kudArr.add(rs.getString("K_telefon"));
                kudArr.add(rs.getString("K_vorname"));
            }
            return kudArr;
        } catch (Exception e) {

        }
        return kudArr;
    }

    @Override
    public int getKundeIDByLogin(String mail, String pass) {
        int uID = 0;
        try {
            Statement stmt = _con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT K_ID from KundeT where K_email = '"+mail+"' AND K_passwort = '"+pass+"';");
            stmt.close();
            while (rs.next()){
                uID = rs.getInt("K_ID");
            }
            return uID;
        } catch (Exception e) {

        }
        return uID;
    }

    @Override
    public List<String> getAdressByID(int id) {
        List<String> adrArr = new ArrayList<String>();
        try {
            Statement stmt = _con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT A_strasse, A_hausnummer, A_plz, A_Stadt, A_adresszusatz from KundeT,AdresseT where K_ID ="+id+" AND A_ID = K_adresse;");
            stmt.close();
            while (rs.next()){
                adrArr.add(rs.getString("A_strasse"));
                adrArr.add(rs.getString("A_hausnummer"));
                adrArr.add(rs.getString("A_plz"));
                adrArr.add(rs.getString("A_Stadt"));
                adrArr.add(rs.getString("A_adresszusatz"));
            }
            return adrArr;
        } catch (Exception e) {

        }
        return adrArr;
    }

    @Override
    public boolean setVorname(int id, String vorname) {
        return false;
    }

    @Override
    public boolean setNachname(int id, String nachname) {
        return false;
    }

    @Override
    public boolean setAdresse(int id, List<String> adresse) {
        return false;
    }

    @Override
    public boolean setEMail(int id, String email) {
        return false;
    }

    @Override
    public boolean setPasswort(int id, String passwort) {
        return false;
    }

    @Override
    public boolean setNeuerKunde(String email, String passwort, String vorname, String nachname, String gebDatum, String telefonummer, String strasse, int hausnummer, String adresszusatz, int plz, String stadt) {
        List<String> adrArr = new ArrayList<String>();
        try {
            Statement stmt = _con.createStatement();
            stmt.execute("INSERT INTO AdresseT (A_adresszusatz, A_hausnummer, A_plz, A_Stadt, A_strasse)" +
                    "VALUES ('" + adresszusatz + "', " + hausnummer + ", " + plz + ",'" + stadt + "', '" + strasse + "');");
            ResultSet rs = stmt.executeQuery("SELECT MAX( A_ID ) AS A_ID FROM AdresseT;");
            rs.next();
            String adressindex = rs.getString("A_ID");
            stmt.execute("INSERT INTO KundeT (K_adresse, K_email, K_nachname, K_passwort, K_telefon, K_vorname, K_gebdatum)" +
                    " VALUES ("+adressindex+",'"+email+"', '"+nachname+"', '"+passwort+"', '"+telefonummer+"', '"+vorname+"','"+gebDatum+"');");
            stmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
