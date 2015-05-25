package models.Exception;

/**
 * Created by dima on 25.05.15.
 */
public class ValuesCreateException extends Exception {

    private String message;

    public ValuesCreateException(){}

    public ValuesCreateException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return (message != null ? message : super.getMessage());
    }
}
