package org.example;

public class Main {
    public static void main(String[] args) {


        Choklad snickers = new Choklad(1,15,"Snickers");
        Chips grillChips = new Chips(1,28,"OLW GrillChips");
        System.out.println(snickers.use());
        System.out.println(grillChips.use());
    }
}