package models.Exception;

/**
 * Created by dima on 25.05.15.
 */
public class UngueltigerStepException extends Exception{

    private String message;

    public UngueltigerStepException(){}

    public UngueltigerStepException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return (message != null ? message : super.getMessage());
    }
}
