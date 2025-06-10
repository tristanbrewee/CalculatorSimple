package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input: ");
        char input = sc.nextLine().charAt(0);
        char output = IOClass.checkInput(input);
        System.out.println(output);
    }
}