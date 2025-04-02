package org.example;

public class Main {
    public static void main(String[] args) {



        Choklad snickers = new Choklad(2,15,"Snickers");
        Chips grillChips = new Chips(1,28,"OLW GrillChips");
        Product [] arrays  = {snickers,grillChips};
        VendingMachineImpl vending = new VendingMachineImpl(arrays);

    }
}