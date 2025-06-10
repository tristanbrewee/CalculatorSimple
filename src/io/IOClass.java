package io;

import exceptions.DotException;
import exceptions.InvalidInputException;

public class IOClass {

    public static char checkInput(char input){
        try{
            checkIfValidInput(input);
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

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
