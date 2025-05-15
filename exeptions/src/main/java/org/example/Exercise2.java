package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Skriv ett heltal mellan 1 och 100: ");
            int number = scanner.nextInt();

            if (number < 1 || number > 100) {
                throw new IllegalArgumentException("Talet är utanför tillåtet område (1–100).");
            }

            System.out.println("Du skrev ett giltigt tal: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Fel: Du måste skriva ett heltal.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fel: " + e.getMessage());
        }
    }

}
