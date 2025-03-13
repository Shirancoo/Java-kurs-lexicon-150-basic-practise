package Markus.org;

import java.util.Scanner;

public class CurrencyExanger {

    public static double sekToUsd(double sek) {
        sek = sek * 0.315;
        return sek;

    }

    public static double usdToSek(double usd) {
        usd = usd * 3.15;
        return usd;
    }

    public static double sekToEuro(double sek) {
        sek = sek * 0.95;
        return sek;
    }

    public static double euroToSek(double euro) {
        euro = euro * 3.315;
        return euro;
    }


}

