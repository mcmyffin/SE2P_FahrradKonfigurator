/**
 * Created by tin on 07.04.15.
 */
public interface IDatabase {

    /*
    * Methode zum erzeugne einer Verbindung zur Datenbank
    * @result Erfolg -> true
    * */
    public boolean getConnectionFile();

    /*
    * Methode zum erstellen eines ConnectionFiles
    * @result Erfolg -> true
    *
    * */
    public boolean createConnectionFile();

}
