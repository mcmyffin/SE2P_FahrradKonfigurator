package models.Exception;

/**
 * Created by dima on 24.05.15.
 */
public class EinzelteileTypException extends Exception {

    private String message;

    public EinzelteileTypException() throws EinzelteileTypException{

    }

    public EinzelteileTypException(String message) throws EinzelteileTypException{
        this.message = message;
    }

    @Override
    public String getMessage() {
        return (message == null ? super.getMessage() : message);
    }
}
