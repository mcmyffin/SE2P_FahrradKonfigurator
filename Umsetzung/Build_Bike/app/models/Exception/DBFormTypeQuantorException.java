package models.Exception;

/**
 * Created by dima on 25.05.15.
 */
public class DBFormTypeQuantorException extends Exception {

    private String message;

    public DBFormTypeQuantorException(){}

    public DBFormTypeQuantorException(String message){
        this.message = message;
    }


    @Override
    public String getMessage() {
        return (message != null ? message : super.getMessage());
    }
}
