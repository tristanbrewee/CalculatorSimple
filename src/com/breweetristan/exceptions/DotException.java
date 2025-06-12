package com.breweetristan.exceptions;

public class DotException extends RuntimeException {

    @Override
    public String getMessage(){
        return "You can only have one coma (dot) in a number.";
    }
}
