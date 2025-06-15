package com.breweetristan.io;

import com.breweetristan.exceptions.*;

public class IOClass {

    /*
    This method calls checkIfValidInput(char) and catches the possible Exception
     */
    public static String checkInput(String input){
        try{
            for (int i = 0; i < input.length(); i++){
                checkIfValidInput(input.charAt(i));
            }
            checkIfValidSyntax(input);
            return input;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /*
    This method check if the given input isn't empty
    It checks if the given input doesn't start with *, /, or +
    It checks, when it starts with a -, if it is not followed by a -, +, *, of /
    It checks if the input doesn't end with -, +, *, or /
    It checks if there are no symbols followed by other symbols (exception being a second -)
    It checks if there are is a second -, if there isn't a symbol after that
     */
    private static void checkIfValidSyntax(String input){
        if(input.isEmpty())
            throw new NoInputException();
        if (input.charAt(0) == '*' ||
                input.charAt(0) == '/' ||
                input.charAt(0) == '+')
            throw new InvalidSyntaxException();
        if (input.charAt(0) == '-'){
            if (input.length() == 1)
                throw new InvalidSyntaxException();
        }
        if (input.charAt(input.length() - 1) == '-' ||
                input.charAt(input.length() - 1) == '+' ||
                input.charAt(input.length() - 1) == '*' ||
                input.charAt(input.length() - 1) == '/')
            throw new InvalidSyntaxException();
        //TODO: It checks, when it starts with a -, if it is not followed by a -, +, *, of /
        //TODO: It checks if there are no symbols followed by other symbols (exception being a second -)
        //TODO: It checks if there are is a second -, if there isn't a symbol after that
    }

    /*
    This method checks if the given char is within the allowed characters
    The allowed characters are 0 to 9, '.', '+', '-', '*',  and '/'
    */
    private static void checkIfValidInput(char input) throws InvalidInputException{
        if(((int)(input) >= 48 &&
                    (int)(input) <= 57) ||
                input == '.' ||
                (input == '+' ||
                        input == '-' ||
                        input == '*' ||
                        input == '/')) {
        }
        else
            throw new InvalidInputException();
    }

    /*
    Check if the given String contains no more than maximum one coma (dot)
    This method should be called on numbers input only
    */
    public static String checkNumberOfDots(String number){
        try {
            int numberOfDots = 0;
            for(int i = 0; i < number.length(); i++){
                if (number.charAt(i) == '.'){
                    numberOfDots++;
                    if (numberOfDots > 1)
                        throw new DotException();
                }
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return number;
    }

}
