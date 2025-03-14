package Markus.org;

public class currencyExchanger {

    // Exchange rates as of March 14, 2025
    public static final double SekRate = 0.098;
    public static final double usdRate = 10.20;
    public static final double euroRate = 0.090;
    public static final double SekERate = 11.07;

    // Currency symbols
    public static final String getSekSymbol = "Kr";
    public static final char getEuroSymbol = '€';
    public static final char getDollarSymbol = '$';

    // Conversion methods
    public static double sekToUsd(double sek) {
        return sek * SekRate;
    }

    public static double usdToSek(double usd) {
        return usd * usdRate;
    }

    public static double sekToEuro(double sek) {
        return sek * euroRate;
    }

    public static double euroToSek(double euro) {
        return euro * SekERate;
    }

    // Method to print the menu
    public static void menuPrint() {
        System.out.println("\n-------------------------------------");
        System.out.println("Welcome to my Currency Converter App");
        System.out.println("-------------------------------------");
        System.out.println("Please make a choice 0-4 of what you want to exchange or exit program:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to Euro");
        System.out.println("4. Convert Euro to SEK");
        System.out.println("0. Close Program");
        System.out.println("-------------------------------------");
        System.out.print("Enter Your Choice: ");
    }
}
