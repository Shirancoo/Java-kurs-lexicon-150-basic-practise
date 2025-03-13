package Markus.org;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //Requirements
        //1. Menu Display: The application should display a menu to the user with options to
        //convert between different currencies or exit the program.
        //2. User Input Handling: The application should capture user input for menu choices and
        //currency amounts.
        //3. Currency Conversion: The application should accurately convert amounts between
        //SEK, USD, and Euro using predefined exchange rates.
        //4. Formatted Output: The application should display conversion results in a formatted
        //manner along with the current date and time.
        //5. Data Validation: The application should handle invalid inputs gracefully (e.g., non
        //numeric values, negative amounts).
        //6. Code Structure: The application should be well-structured using classes and methods
        //for clarity and maintainability.

        boolean isRunning = true;
        String choise;

        while (isRunning) {

            System.out.println("-------------------------------------");
            System.out.println("Welcome to my Currency Converter App ");
            System.out.println("-------------------------------------");
            System.out.println("Please make a choice 1-4 of what you want to exchange or exit program");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Enter Your Choise: ");
            choise = input.next();


            switch (choise) {
                case "1":
                    System.out.println("Convert SEK to USD");
                    break;

                case "2":
                    System.out.println("Convert USD to SEK");
                    break;
                case "3":
                    System.out.println("Convert SEK to EURO");
                    break;
                case "4":
                    System.out.println("Convert EURO to SEK");
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("Closing Program");
                    break;
                default:
                    System.out.println("Please Insert a number between 0-4 to make a choose if you want to exit press 0");
            }


        }

    }
}