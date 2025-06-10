package exceptions;

public class InvalidInputException extends Exception{

    @Override
    public String getMessage(){
        return "You can only enter numbers or ., +, -, *, or /";
    }
}
