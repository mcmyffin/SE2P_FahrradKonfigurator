package models.Exception;

/**
 * Created by dima on 24.05.15.
 */
public class EinzelteileTypException extends Exception {

    private String message;

    public EinzelteileTypException(){

    }

    public EinzelteileTypException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return (message == null ? super.getMessage() : message);
    }
}
