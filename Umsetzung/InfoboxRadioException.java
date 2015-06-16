package se2;
//package models.Exception;

/**
 * @author Henning Kahl
 */

public class InfoboxRadioException extends Exception {
    private String message;
    
    public InfoboxRadioException(){}

    public InfoboxRadioException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return (message != null ? message : super.getMessage());
    }
}
