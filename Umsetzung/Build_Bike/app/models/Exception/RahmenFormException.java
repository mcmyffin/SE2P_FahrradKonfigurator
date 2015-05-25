package models.Exception;

/**
 * Created by dima on 24.05.15.
 */
public class RahmenFormException extends Exception{

    private String message;

    public RahmenFormException(){}

    public RahmenFormException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return (message != null ? message : super.getMessage());
    }
}
