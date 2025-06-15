package com.breweetristan.calculations;

import com.breweetristan.exceptions.NotAnOperationException;
import com.breweetristan.io.IOClass;

public class CalculationClass {

    /*
    This method is the starting point for calculations to be verified and eventually solved
     */
    public static String start(String calculation){
        String output = IOClass.checkInput(calculation);
        if (!output.equals(calculation))
            return output;
        output = solve(calculation);
        return output;
    }

    /*
    This method solves the given calculation based on priority operations
     */
    private static String solve(String calculation){
        int amountPriorityOperations = getNumberOfPriorityOperations(calculation);
        if (amountPriorityOperations > 0)
            calculation = findAndSolve(calculation, true);
        return findAndSolve(calculation, false);
    }

    private static String findAndSolve(String calculation, boolean priority){
        //Determine which operations we're solving
        char operation1, operation2;
        if (priority){
            operation1 = '*';
            operation2 = '/';
        }else {
            operation1 = '+';
            operation2 = '-';
        }
        //Loop over calculation
        for (int i = 1; i < calculation.length(); i++){
            //Operation found
            if (calculation.charAt(i) == operation1 ||
                    calculation.charAt(i) == operation2){
                String number1, number2;
                int indexStart = 0, indexEnd = calculation.length();
                //Determine the start index of the number before the operation
                for(int j = i - 1; j >= 0; j--){
                    if (calculation.charAt(j) == '/' ||
                            calculation.charAt(j) == '*' ||
                            calculation.charAt(j) == '+' ){
                        indexStart = j + 1;
                        break;
                    } else if (calculation.charAt(j) == '-') {
                        if (j == 0 ||
                                calculation.charAt(j - 1) == '/' ||
                                calculation.charAt(j - 1) == '*' ||
                                calculation.charAt(j - 1) == '-' ||
                                calculation.charAt(j - 1) == '+'){
                            indexStart = j;
                            break;
                        } else {
                            indexStart = j + 1;
                            break;
                        }
                    }
                }
                //Determine the end index of the number after the operation
                for(int j = i + 1; j <= calculation.length(); j++){
                    if (j == calculation.length() ||
                            calculation.charAt(j) == '/' ||
                            calculation.charAt(j) == '*' ||
                            calculation.charAt(j) == '+'){
                        indexEnd = j;
                        break;
                    }
                    if (calculation.charAt(j) == '-')
                        if (j != i + 1){
                            indexEnd = j;
                            break;
                        }
                }
                //Calculate the found operation on the found 2 numbers
                number1 = calculation.substring(indexStart, i);
                number2 = calculation.substring(i + 1, indexEnd);
                //Test for yo many dots
                if (!number1.equals(IOClass.checkNumberOfDots(number1)))
                    return IOClass.checkNumberOfDots(number1);
                if (!number2.equals(IOClass.checkNumberOfDots(number2)))
                    return IOClass.checkNumberOfDots(number2);
                String result = calculate(number1, number2, calculation.charAt(i));
                //Replace the solved part of the calculation and reset the loop
                calculation = calculation.substring(0, indexStart) + result + calculation.substring(indexEnd);
                System.out.println(calculation);
                i = 0;
            }
        }
        return calculation;
    }

    /*
    This methods gets the amount of priority operations from the given calculation
     */
    private static int getNumberOfPriorityOperations(String calculation){
        return (int)calculation.chars().filter(e->e=='/').count() +
                (int)calculation.chars().filter(e->e =='*').count();
    }

    /*
    This method performs the operation requested (char operation) from number1 to number2
    It catches possible incorrect input which leads to number1 or number2 not being a number
    It catches possible incorrect input which leads to 'operation' not being a valid operation
     */
    private static String calculate(String number1, String number2, char operation){
        double numberA, numberB;
        try{
            numberA = Double.parseDouble(number1);
            numberB = Double.parseDouble(number2);
        }catch (Exception e){
            return "Error parsing numbers";
        }
        try{
            if (operation == '+')
                return String.valueOf(add(numberA, numberB));
            if (operation == '-')
                return String.valueOf(subtract(numberA, numberB));
            if (operation == '*')
                return String.valueOf(multiply(numberA, numberB));
            if (operation == '/')
                return String.valueOf(divide(numberA, numberB));
            throw new NotAnOperationException();
        }catch (Exception e){
            return e.getMessage();
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
