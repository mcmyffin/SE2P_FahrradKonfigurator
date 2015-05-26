package models.Exception;

/**
 * Created by dima on 24.05.15.
 */
public class KonfigurationException extends Exception{

    private String message;

    public KonfigurationException(){}

    public KonfigurationException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return (message != null ? message : super.getMessage());
    }
}
