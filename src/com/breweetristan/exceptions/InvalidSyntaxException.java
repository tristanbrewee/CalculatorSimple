package com.breweetristan.exceptions;

public class InvalidSyntaxException extends RuntimeException {

    @Override
    public String getMessage(){
        return "An invalid syntax was entered.";
    }
}
