package Markus.org;

import java.time.LocalDate;
import java.util.Scanner;

public class CurrencyConverterStart {

    private static Scanner input;

    public static void start() {
        Scanner input = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            currencyExchanger.menuPrint();

            String choice = input.next();
            switch (choice) {

                case "1":
                    System.out.println(LocalDate.now() + " SEK to dollars Currency rate: " + currencyExchanger.SekRate);
                    System.out.print("Enter the amount of SEK to USD: ");
                    System.out.println(" Current currency rate: " + currencyExchanger.SekRate);
                    double sekToUs = currencyExchanger.sekToUsd(input.nextDouble());
                    System.out.println(LocalDate.now() + " Amount: " + sekToUs + currencyExchanger.getDollarSymbol);

                    break;

                case "2":
                    System.out.println(LocalDate.now() + " Dollars to SEK Currency rate: " + currencyExchanger.usdRate);
                    System.out.print("Enter the amount of USD to SEK: ");
                    double usdToSe = currencyExchanger.usdToSek(input.nextDouble());
                    System.out.println(LocalDate.now() + " Amount: " + usdToSe + currencyExchanger.getSekSymbol);

                    break;
                case "3":
                    System.out.println(LocalDate.now() + " SEK to Euro Currency rate: " + currencyExchanger.euroRate);
                    System.out.print("Enter the amount of SEK to EURO: ");
                    double sekToEu = currencyExchanger.sekToEuro(input.nextDouble());
                    System.out.println(LocalDate.now() + " Amount: " + sekToEu + currencyExchanger.getEuroSymbol);
                    break;
                case "4":
                    System.out.println(LocalDate.now() + " | Euro to SEK Currency rate: " + currencyExchanger.SekERate);
                    System.out.print("Enter the amount of EURO to SEK: ");
                    double euroToSe = currencyExchanger.euroToSek(input.nextDouble());
                    System.out.println(LocalDate.now() + " Amount: " + euroToSe + currencyExchanger.getSekSymbol);
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("Closing Program...");
                    break;
                default:
                    System.out.println("Please insert a number between 0-4 or enter 0 to exit.");
            }
        }
        input.close();


    }
}
