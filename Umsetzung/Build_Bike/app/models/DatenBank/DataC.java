package models.DatenBank;


import models.Exception.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import models.TeileKomponente.Einzelteile.*;
import org.mariadb.jdbc.*;
import play.db.DB;

/**
 * Created by tin on 01.05.15.
 */
public class DataC implements IDatenBank {

    public DataC(){
    }

    /*private DataC(Connection con){
        _con = con;
    }*/

    /*public static IDatenBank setTestEnv() throws DatabaseException{
        try {
            return new DataC(DriverManager.getConnection("jdbc:mariadb://localhost/FahrradKonfi", "se2", ""));
        } catch (Exception e) {
            throw new DatabaseException("Konnte keine verbindung aufbauen",1);
        }
    }*/

    private ResultSet getDataFormDB(String sqlStmt) throws DatabaseException{
        try {
            Connection con = DB.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStmt);
            stmt.close();
            con.close();
            return rs;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public boolean isKundeExistByMail(String mailadr) throws DatabaseException {
        try {
            ResultSet rs = getDataFormDB("SELECT K_email from KundeT where K_email = '" + mailadr + "';");
            while (rs.next()){
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public List<String> getKundeByID(int id) throws DatabaseException {
        List<String> kudArr = new ArrayList<String>();

        try {
            ResultSet rs = getDataFormDB("SELECT K_adresse, K_email, K_nachname, K_telefon, K_vorname from KundeT where K_ID ="+id+";");
            while (rs.next()){
                kudArr.add(rs.getString("K_adresse"));
                kudArr.add(rs.getString("K_email"));
                kudArr.add(rs.getString("K_nachname"));
                kudArr.add(rs.getString("K_telefon"));
                kudArr.add(rs.getString("K_vorname"));
            }
            return kudArr;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public int getKundeIDByLogin(String mail, String pass) throws DatabaseException {
        int uID = 0;
        try {
            ResultSet rs = getDataFormDB("SELECT K_ID from KundeT where K_email = '"+mail+"' AND K_passwort = '"+pass+"';");
            while (rs.next()){
                uID = rs.getInt("K_ID");
            }
            return uID;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public List<String> getAdressByID(int id) throws DatabaseException {
        List<String> adrArr = new ArrayList<String>();
        try {
            ResultSet rs = getDataFormDB("SELECT A_strasse, A_hausnummer, A_plz, A_Stadt, A_adresszusatz from KundeT,AdresseT where K_ID ="+id+" AND A_ID = K_adresse;");
            while (rs.next()){
                adrArr.add(rs.getString("A_strasse"));
                adrArr.add(rs.getString("A_hausnummer"));
                adrArr.add(rs.getString("A_plz"));
                adrArr.add(rs.getString("A_Stadt"));
                adrArr.add(rs.getString("A_adresszusatz"));
            }
            return adrArr;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public boolean setVorname(int id, String vorname) throws DatabaseException {
        try {
            Connection con = DB.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE KundeT SET K_vorname = '"+ vorname +"' WHERE K_ID ="+id);
            stmt.close();
            con.close();
            return true;
        } catch (Exception e){
            throw new DatabaseException(2);
        }
    }

    @Override
    public boolean setNachname(int id, String nachname) throws DatabaseException {
        try {
            Connection con = DB.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE KundeT SET K_nachname = '"+ nachname +"' WHERE K_ID ="+id);
            stmt.close();
            con.close();
            return true;

        } catch (Exception e){
            throw new DatabaseException(2);
        }
    }

    @Override
    public boolean setAdresse(int id, List<String> adresse) throws DatabaseException {
        return false;
    }

    @Override
    public boolean setEMail(int id, String email) throws DatabaseException {
        try {
            Connection con = DB.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE KundeT SET K_email = '"+ email +"' WHERE K_ID ="+id);
            stmt.close();
            con.close();
            return true;
        } catch (Exception e){
            throw new DatabaseException(2);
        }
    }

    @Override
    public boolean setPasswort(int id, String passwort) throws DatabaseException {
        try {
            Connection con = DB.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE KundeT SET K_passwort = '"+ passwort +"' WHERE K_ID ="+id);
            stmt.close();
            con.close();
            return true;
        } catch (Exception e){
            throw new DatabaseException(2);
        }
    }

    @Override
    public boolean setNeuerKunde(String email, String passwort, String vorname, String nachname, String gebDatum, String telefonummer, String strasse, int hausnummer, String adresszusatz, int plz, String stadt) throws DatabaseException {
        List<String> adrArr = new ArrayList<String>();
        try {
            Connection con = DB.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO AdresseT (A_adresszusatz, A_hausnummer, A_plz, A_Stadt, A_strasse)" +
                    "VALUES ('" + adresszusatz + "', " + hausnummer + ", " + plz + ",'" + stadt + "', '" + strasse + "');");
            ResultSet rs = stmt.executeQuery("SELECT MAX( A_ID ) AS A_ID FROM AdresseT;");
            rs.next();
            String adressindex = rs.getString("A_ID");
            stmt.execute("INSERT INTO KundeT (K_adresse, K_email, K_nachname, K_passwort, K_telefon, K_vorname, K_gebdatum)" +
                    " VALUES ("+adressindex+",'"+email+"', '"+nachname+"', '"+passwort+"', '"+telefonummer+"', '"+vorname+"','"+gebDatum+"');");
            stmt.close();
            con.close();
            return true;
        } catch (Exception e) {
            throw new DatabaseException(2);
        }
    }

    @Override
    public Felge getFelgeByID(int id) throws DatabaseException {
        try {
            ResultSet rs = getDataFormDB("SELECT * from FelgenT where F_id =" + id + ";");
            while (rs.next()){
                return Values.createFelge(rs.getInt("F_ID"),rs.getInt("F_BESCH"), rs.getInt("F_preis"), rs.getInt("F_reifengroesse"), rs.getInt("F_formTyp"), rs.getInt("F_formTypID"), rs.getString("F_bild"), rs.getString("F_name"), rs.getBoolean("F_narbendynamo"));
            }
        } catch (Exception e) {
            throw new DatabaseException(1);
        }

        return null;
    }

    @Override
    public List<Felge> getAllFelgen() throws DatabaseException {
        List<Felge> felList = new LinkedList<Felge>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from FelgenT;");
            while (rs.next()){
                 felList.add(Values.createFelge(rs.getInt("F_ID"), rs.getInt("F_BESCH"), rs.getInt("F_preis"), rs.getInt("F_reifengroesse"), rs.getInt("F_formTyp"), rs.getInt("F_formTypID"), rs.getString("F_bild"), rs.getString("F_name"), rs.getBoolean("F_narbendynamo")));
            }
            return felList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public List<Felge> getFelgeByFormTyp(int formTyp) throws DatabaseException {
        List<Felge> felList = new LinkedList<Felge>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from FelgenT WHERE F_formTyp ="+formTyp+";");
            while (rs.next()){
                felList.add(Values.createFelge(rs.getInt("F_ID"), rs.getInt("F_BESCH"), rs.getInt("F_preis"), rs.getInt("F_reifengroesse"), rs.getInt("F_formTyp"), rs.getInt("F_formTypID"), rs.getString("F_bild"), rs.getString("F_name"), rs.getBoolean("F_narbendynamo")));
            }
            return felList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public FormTyp getFormTypTabelleByFelgeID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Beschreibung getBeschreibungByFelgeID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Gabel getGabelnByID(int id) throws DatabaseException {
        try {
            ResultSet rs = getDataFormDB("SELECT * from GabelT where G_ID ="+id+";");
            while (rs.next()){
                return Values.createGabel(rs.getInt("G_ID"),rs.getInt("G_BESCH"),
                        rs.getInt("G_formTyp"), rs.getInt("G_formTypID"),
                        rs.getInt("G_schaftlaenge"), rs.getInt("G_steuersatz"),
                        rs.getInt("G_reifengroesse"), rs.getInt("G_preis"),
                        rs.getBoolean("G_felgenBrems"), rs.getBoolean("G_scheibenbrems"),
                        rs.getBoolean("G_licht"), rs.getString("G_bild"), rs.getString("G_name"));
            }
        } catch (Exception e) {
            throw new DatabaseException(1);
        }

        return null;
    }

    @Override
    public List<Gabel> getAllGabel() throws DatabaseException {
        List<Gabel> gabList = new LinkedList<Gabel>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from GabelT where G_ID;");
            while (rs.next()){
                gabList.add(Values.createGabel(rs.getInt("G_ID"), rs.getInt("G_BESCH"), rs.getInt("G_formTyp"),
                        rs.getInt("G_formTypID"), rs.getInt("G_schaftlaenge"), rs.getInt("G_steuersatz"),
                        rs.getInt("G_reifengroesse"), rs.getInt("G_preis"), rs.getBoolean("G_felgenBrems"),
                        rs.getBoolean("G_scheibenbrems"), rs.getBoolean("G_licht"), rs.getString("G_bild"),
                        rs.getString("G_name")));
            }
            return gabList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public List<Gabel> getGabelByFormTyp(int formTyp) throws DatabaseException {
        List<Gabel> gabList = new LinkedList<Gabel>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from GabelT where G_formTyp ="+formTyp+";");
            while (rs.next()){
                gabList.add(Values.createGabel(rs.getInt("G_ID"), rs.getInt("G_BESCH"), rs.getInt("G_formTyp"),
                        rs.getInt("G_formTypID"), rs.getInt("G_schaftlaenge"), rs.getInt("G_steuersatz"),
                        rs.getInt("G_reifengroesse"), rs.getInt("G_preis"), rs.getBoolean("G_felgenBrems"),
                        rs.getBoolean("G_scheibenbrems"), rs.getBoolean("G_licht"), rs.getString("G_bild"),
                        rs.getString("G_name")));
            }
            return gabList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public FormTyp getFormTypTabelleByGabelID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Beschreibung getBeschreibungByGabelID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Mantel getMantelByID(int id) throws DatabaseException {
        try {
            ResultSet rs = getDataFormDB("SELECT * from MantelT where M_ID ="+id+";");
            while (rs.next()){
                return Values.createMantel(rs.getInt("M_ID"), rs.getInt("M_BESCH"), rs.getInt("M_formTyp"), rs.getInt("M_formTypID"), rs.getInt("M_durchm"), rs.getInt("M_reifengroesse"), rs.getInt("M_preis"), rs.getString("M_bild"), rs.getString("M_name"));
            }
        } catch (Exception e) {
            throw new DatabaseException(1);
        }

        return null;
    }

    @Override
    public List<Mantel> getAllMantel() throws DatabaseException {
        List<Mantel> manList = new LinkedList<Mantel>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from MantelT;");
            while (rs.next()){
                manList.add(Values.createMantel(rs.getInt("M_ID"), rs.getInt("M_BESCH"), rs.getInt("M_formTyp"), rs.getInt("M_formTypID"), rs.getInt("M_durchm"), rs.getInt("M_reifengroesse"), rs.getInt("M_preis"), rs.getString("M_bild"), rs.getString("M_name")));
            }
            return manList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public List<Mantel> getMantelByFormTyp(int formTyp) throws DatabaseException {
        List<Mantel> manList = new LinkedList<Mantel>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from MantelT where M_formTyp ="+formTyp+";");
            while (rs.next()){
                manList.add(Values.createMantel(rs.getInt("M_ID"),rs.getInt("M_BESCH"), rs.getInt("M_formTyp"), rs.getInt("M_formTypID"), rs.getInt("M_durchm"), rs.getInt("M_reifengroesse"), rs.getInt("M_preis"), rs.getString("M_bild"), rs.getString("M_name")));
            }
            return manList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public FormTyp getFormTypTabelleByMantelID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Beschreibung getBeschreibungByMantelID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public List<Rahmen> getRahmenByFormtyp(int formTyp) throws DatabaseException {
        List<Rahmen> rahList = new LinkedList<Rahmen>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from RahmenT where R_formTyp ="+formTyp+";");
            while (rs.next()){
                 rahList.add(Values.createRahmen(rs.getInt("R_ID"), rs.getString("R_hoehe"), rs.getInt("R_form"), rs.getInt("R_reifengroesse"),
                         rs.getString("R_bild"), rs.getInt("R_BESCH"), rs.getInt("R_steuersatz"),
                         rs.getInt("R_schafthoehe"), rs.getInt("R_zusatzbefest"),
                         rs.getBoolean("R_scheibenbrems"), rs.getBoolean("R_felgenbrems"),
                         rs.getInt("R_tretlager"), rs.getInt("R_formTyp"), rs.getInt("R_formTypID"),
                         rs.getString("R_name"), rs.getInt("R_preis"), rs.getBoolean("R_gepaektraeger"),
                         rs.getBoolean("R_licht"),rs.getString("R_farbe")));
            }
            return rahList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public Rahmen getRahmenByID(int rID) throws DatabaseException {
        try {
            ResultSet rs = getDataFormDB("SELECT * from RahmenT where R_ID ="+rID+";");
            while (rs.next()){
                return Values.createRahmen(rs.getInt("R_ID"), rs.getString("R_hoehe"), rs.getInt("R_form"), rs.getInt("R_reifengroesse"),
                        rs.getString("R_bild"), rs.getInt("R_BESCH"), rs.getInt("R_steuersatz"),
                        rs.getInt("R_schafthoehe"), rs.getInt("R_zusatzbefest"),
                        rs.getBoolean("R_scheibenbrems"), rs.getBoolean("R_felgenbrems"),
                        rs.getInt("R_tretlager"), rs.getInt("R_formTyp"), rs.getInt("R_formTypID"),
                        rs.getString("R_name"), rs.getInt("R_preis"), rs.getBoolean("R_gepaektraeger"),
                        rs.getBoolean("R_licht"),rs.getString("R_farbe"));
            }
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
        return null;
    }

    @Override
    public Beschreibung getBeschreibungByRahmenID(int rID) throws DatabaseException {
        return null;
    }

    @Override
    public FormTyp getFormTypTabelleByRahmenID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public List<Rahmen> getAllRahmen() throws DatabaseException {
        List<Rahmen> rahList = new LinkedList<Rahmen>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from RahmenT;");
            while (rs.next()){
                rahList.add(Values.createRahmen(rs.getInt("R_ID"), rs.getString("R_hoehe"), rs.getInt("R_form"), rs.getInt("R_reifengroesse"),
                        rs.getString("R_bild"), rs.getInt("R_BESCH"), rs.getInt("R_steuersatz"),
                        rs.getInt("R_schafthoehe"), rs.getInt("R_zusatzbefest"),
                        rs.getBoolean("R_scheibenbrems"), rs.getBoolean("R_felgenbrems"),
                        rs.getInt("R_tretlager"), rs.getInt("R_formTyp"), rs.getInt("R_formTypID"),
                        rs.getString("R_name"), rs.getInt("R_preis"), rs.getBoolean("R_gepaektraeger"),
                        rs.getBoolean("R_licht"),rs.getString("R_farbe")));
            }
            return rahList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public Sattel getSattelByID(int id) throws DatabaseException {
        try {
            ResultSet rs = getDataFormDB("SELECT * from SattelT WHERE S_ID ="+id+";");
            while (rs.next()){
                return Values.createSattel(rs.getInt("S_ID"), rs.getString("S_name"), rs.getInt("S_BESCH"), rs.getInt("S_preis"), rs.getInt("S_formTyp"), rs.getInt("S_formTypID"), rs.getString("S_bild"));
            }
        } catch (Exception e) {
            throw new DatabaseException(1);
        }

        return null;
    }

    @Override
    public List<Sattel> getAllSattel() throws DatabaseException {
        List<Sattel> satList = new LinkedList<Sattel>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from SattelT;");
            while (rs.next()){
                satList.add(Values.createSattel(rs.getInt("S_ID"), rs.getString("S_name"), rs.getInt("S_BESCH"), rs.getInt("S_preis"), rs.getInt("S_formTyp"), rs.getInt("S_formTypID"), rs.getString("S_bild")));
            }
            return satList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public List<Sattel> getSattelByFormTyp(int formTyp) throws DatabaseException {
        List<Sattel> satList = new LinkedList<Sattel>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from SattelT WHERE S_formtyp ="+formTyp+";");
            while (rs.next()){
                satList.add(Values.createSattel(rs.getInt("S_ID"), rs.getString("S_name"), rs.getInt("S_BESCH"), rs.getInt("S_preis"), rs.getInt("S_formTyp"), rs.getInt("S_formTypID"), rs.getString("S_bild")));
            }
            return satList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public FormTyp getFormTypTabelleBySattelID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Beschreibung getBeschreibungBySattelID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Zubehoer getTeileByID(int id) throws DatabaseException {
        try {
            ResultSet rs = getDataFormDB("SELECT * from TeileT WHERE T_ID ="+id+";");
            while (rs.next()){
                return Values.createZubehoer(rs.getInt("T_ID"), rs.getInt("T_BESCH"), rs.getInt("T_preis"), rs.getInt("T_formTyp"), rs.getInt("T_formTypID"), rs.getString("T_bild"), rs.getString("T_name"), rs.getBoolean("T_zusatzBelegt"));
            }
        } catch (Exception e) {
            throw new DatabaseException(1);
        }

        return null;
    }

    @Override
    public List<Zubehoer> getAllTeile() throws DatabaseException {
        List<Zubehoer> zubList = new LinkedList<Zubehoer>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from TeileT;");
            while (rs.next()){
                zubList.add(Values.createZubehoer(rs.getInt("T_ID"), rs.getInt("T_BESCH"), rs.getInt("T_preis"), rs.getInt("T_formTyp"), rs.getInt("T_formTypID"), rs.getString("T_bild"), rs.getString("T_name"), rs.getBoolean("T_zusatzBelegt")));
            }
            return zubList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public List<Zubehoer> getTeileByFormTyp(int formTyp) throws DatabaseException {
        List<Zubehoer> zubList = new LinkedList<Zubehoer>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from TeileT WHERE T_formtyp ="+formTyp+";");
            while (rs.next()){
                zubList.add(Values.createZubehoer(rs.getInt("T_ID"), rs.getInt("T_BESCH"), rs.getInt("T_preis"), rs.getInt("T_formTyp"), rs.getInt("T_formTypID"), rs.getString("T_bild"), rs.getString("T_name"), rs.getBoolean("T_zusatzBelegt")));
            }
            return zubList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public FormTyp getFormTypTabelleByTeileID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Beschreibung getBeschreibungByTeileID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Vorbau getVorbauByID(int id) throws DatabaseException {
        try {
            ResultSet rs = getDataFormDB("SELECT * from VorbauT WHERE V_ID ="+id+";");
            while (rs.next()){
                return Values.createVorbau(rs.getInt("V_ID"), rs.getInt("V_BESCH"), rs.getInt("V_preis"), rs.getInt("V_schaftgroesse"), rs.getInt("V_formtyp"), rs.getInt("V_formTypID"), rs.getString("V_bild"));
            }
        } catch (Exception e) {
            throw new DatabaseException(1);
        }

        return null;
    }

    @Override
    public List<Vorbau> getAllVorbau() throws DatabaseException {
        List<Vorbau> vorList = new LinkedList<Vorbau>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from VorbauT;");
            while (rs.next()){
                vorList.add(Values.createVorbau(rs.getInt("V_ID"), rs.getInt("V_BESCH"), rs.getInt("V_preis"), rs.getInt("V_schaftgroesse"), rs.getInt("V_formtyp"), rs.getInt("V_formTypID"), rs.getString("V_bild")));
            }
            return vorList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public List<Vorbau> getVorbauByFormTyp(int formTyp) throws DatabaseException {
        List<Vorbau> vorList = new LinkedList<Vorbau>();
        try {
            ResultSet rs = getDataFormDB("SELECT * from VorbauT WHERE V_formtyp="+formTyp+";");
            while (rs.next()){
                vorList.add(Values.createVorbau(rs.getInt("V_ID"), rs.getInt("V_BESCH"), rs.getInt("V_preis"), rs.getInt("V_schaftgroesse"), rs.getInt("V_formtyp"), rs.getInt("V_formTypID"), rs.getString("V_bild")));
            }
            return vorList;
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public FormTyp getFormTypTabelleByVorbauID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Beschreibung getBeschreibungByVorbauID(int id) throws DatabaseException {
        return null;
    }

    @Override
    public Beschreibung getBeschreibungByID(int id) throws DatabaseException {
        try {
            ResultSet rs = getDataFormDB("SELECT * from BeschreibungT WHERE B_ID="+id+";");
            rs.next();

            return new Beschreibung(rs.getString("B_kurzbesch"),rs.getString("B_text"));
        } catch (Exception e) {
            throw new DatabaseException(1);
        }
    }

    @Override
    public FormTyp getFormTypTabelleByID(int id) throws DatabaseException {
        return null;
    }
}
