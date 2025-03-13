package Markus.org;

import java.util.Scanner;

public class CurrencyConverterStart {

    public static void start() {
        Scanner input = new Scanner(System.in);
        CurrencyExanger usdexanger = new CurrencyExanger();

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("-------------------------------------");
            System.out.println("Welcome to my Currency Converter App ");
            System.out.println("-------------------------------------");
            System.out.println("Please make a choice 0-4 of what you want to exchange or exit program");
            System.out.println("1. Convert SEK to USD");
            System.out.println("2. Convert USD to SEK");
            System.out.println("3. Convert SEK to Euro");
            System.out.println("4. Convert Euro to SEK");
            System.out.println("0. Close Program");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Enter Your Choice: ");
            String choice = input.next();


            switch (choice) {
                case "1":

                    System.out.print("Enter the amount of SEK you want to convert to USD ");
                    double sekToUs = CurrencyExanger.sekToUsd(input.nextDouble());
                    System.out.println("Amount: " + CurrencyExanger.sekToUsd(sekToUs) + "$");

                    break;

                case "2":
                    System.out.print("Enter the amount of USD you want to convert to SEK ");
                    double usdToSe = CurrencyExanger.usdToSek(input.nextDouble());
                    System.out.println("Amount: " + CurrencyExanger.usdToSek(usdToSe) + "Kr");

                    break;
                case "3":
                    System.out.print("Enter the amount of SEK you want to convert to EURO ");
                    double sekToEu = CurrencyExanger.sekToEuro(input.nextDouble());
                    System.out.println("Amount: " + CurrencyExanger.sekToEuro(sekToEu) + "£");
                    break;
                case "4":
                    System.out.print("Enter the amount of Euro you want to convert to SEK ");
                    double euroToSe = CurrencyExanger.euroToSek(input.nextDouble());
                    System.out.println("Amount: " + CurrencyExanger.euroToSek(euroToSe) + "Kr");
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("Closing Program");
                    break;
                default:
                    System.out.println("Please Insert a number between 0-4 to make a choose if you want to exit press 0");

            }


        }
        input.close();
    }
}