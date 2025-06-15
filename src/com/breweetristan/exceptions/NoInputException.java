package com.breweetristan.exceptions;

public class NoInputException extends RuntimeException {

    @Override
    public String getMessage(){
        return "No input was given.";
    }
}
