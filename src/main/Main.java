package main;

import io.IOClass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input: ");
        String input = sc.nextLine();
        for(char c : input.toCharArray()){
            IOClass.checkInput(c);
        }
        System.out.println(IOClass.checkNumberOfDots(input));
    }
}