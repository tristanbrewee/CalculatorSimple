package main;

import calculations.CalculationClass;
import io.IOClass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Getting the first number and checking the input
        System.out.println("Enter first number: ");
        String number1 = sc.nextLine();
        for(char c : number1.toCharArray()){
            IOClass.checkInput(c);
        }
        IOClass.checkNumberOfDots(number1);

        //Getting the operation
        System.out.println("Enter the operation");
        String operation = sc.nextLine();
        IOClass.checkInput(operation.charAt(0));

        //Getting the second number and checking the input
        System.out.println("Enter second number: ");
        String number2 = sc.nextLine();
        for(char c : number2.toCharArray()){
            IOClass.checkInput(c);
        }
        IOClass.checkNumberOfDots(number2);

        //Performing the operation
        System.out.println(CalculationClass.calculate(number1, number2, operation.charAt(0)));
    }
}