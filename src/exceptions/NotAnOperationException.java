package exceptions;

public class NotAnOperationException extends RuntimeException {

    @Override
    public String getMessage(){
        return "An invalid operation was entered.";
    }
}
