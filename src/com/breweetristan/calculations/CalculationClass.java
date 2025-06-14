package com.breweetristan.calculations;

import com.breweetristan.exceptions.NotAnOperationException;
import com.breweetristan.io.IOClass;

public class CalculationClass {

    /*
    This method is the starting point for calculations to be verified and eventually solved
     */
    public static String start(String calculation){
        String output = IOClass.checkInput(calculation);
        if (output.equals("You can only enter numbers or ., +, -, *, or /"))
            return output;
        return output;
    }

    /*
    This method performs the operation requested (char operation) from number1 to number2
    It catches possible incorrect input which leads to number1 or number2 not being a number
    It catches possible incorrect input which leads to 'operation' not being a valid operation
     */
    public static double calculate(String number1, String number2, char operation){
        double numberA, numberB;
        try{
            numberA = Double.parseDouble(number1);
            numberB = Double.parseDouble(number2);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        try{
            if (operation == '+')
                return add(numberA, numberB);
            if (operation == '-')
                return subtract(numberA, numberB);
            if (operation == '*')
                return multiply(numberA, numberB);
            if (operation == '/')
                return divide(numberA, numberB);
            throw new NotAnOperationException();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    /*
    This method adds double a to double b
     */
    private static double add(double a, double b){
        return a + b;
    }

    /*
    This method subtracts double a by double b
     */
    private static double subtract(double a, double b){
        return a - b;
    }

    /*
    This method multiplies double a by double b
     */
    private static double multiply(double a, double b){
        return a * b;
    }

    /*
    This method divides double a by double b
    It catches a possible division by 0
    Should this occur, then the method returns -1
     */
    private static double divide(double a, double b){
        try{
            return a / b;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
