package main;

import exceptions.InvalidInputException;

public class IOClass {

    public static char checkInput(char input){
        try{
            checkIfValidInput(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return input;
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
}
