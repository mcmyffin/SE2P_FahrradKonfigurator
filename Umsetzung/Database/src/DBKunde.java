import java.sql.Connection;
import java.util.List;

/**
 * Created by tin on 08.04.15.
 *
 * Tja, ich weiß zwar manchmal nicht was ich mache, aber ich mache viel ^^
 */
final class DBKunde implements IKunde {
    Connection con;


    @Override
    public boolean isKundeExistByMail(String mailadr) {
        return false;
    }

    @Override
    public List<String> getKundeByID(int id) {
        return null;
    }

    @Override
    public int getKundeIDByLogin(String mail, String pass) {
        return 0;
    }

    @Override
    public List<String> getAdressByID(int id) {
        return null;
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
    public boolean getConnectionFile() {
        return false;
    }

    @Override
    public boolean createConnectionFile() {
        return false;
    }
}
