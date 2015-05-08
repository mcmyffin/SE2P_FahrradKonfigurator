package models.Exception;

/**
 * Created by tin on 07.05.15.
 */
public class DatabaseException extends Exception {
    final int fehlercode;

    public DatabaseException(String s, int fehlercode){
        super(s);
        this.fehlercode = fehlercode;
    }
    public DatabaseException(int fehlercode){
        this.fehlercode = fehlercode;
    }

    @Override
    public String toString() {
        return "Fehler aufgetreten, Fehlercode: " + this.fehlercode;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
