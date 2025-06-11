package io;

import exceptions.DotException;
import exceptions.InvalidInputException;

public class IOClass {

    /*
    This method calls checkIfValidInput(char) and catches the possible Exception
     */
    public static char checkInput(char input){
        try{
            checkIfValidInput(input);
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    /*
    This method checks if the given char is within the allowed characters
    The allowed characters are 0 to 9, '.', '+', '-', '*',  and '/'
    */
    private static char checkIfValidInput(char input) throws InvalidInputException{
        if(((int)(input) >= 48 &&
                    (int)(input) <= 57) ||
                input == '.' ||
                (input == '+' ||
                        input == '-' ||
                        input == '*' ||
                        input == '/'))
            return input;
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
            System.out.println(e.getMessage());
            return null;
        }
        return number;
    }

}
