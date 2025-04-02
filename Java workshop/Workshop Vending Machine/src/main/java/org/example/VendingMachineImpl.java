package org.example;

import java.util.Arrays;

public class VendingMachineImpl implements VendingMachine {
    Product[] products;
    int depositPool;


    public VendingMachineImpl(Product[] products) {
        this.products = products;

    }


    @Override
    public void addCurrency(int amount) {
        switch (amount) {
            case 1 -> depositPool += amount;
            case 2 -> depositPool += amount;
            case 5 -> depositPool += amount;
            case 10 -> depositPool += amount;
            case 20 -> depositPool += amount;
            case 50 -> depositPool += amount;
            case 100 -> depositPool += amount;
            case 200 -> depositPool += amount;
            case 500 -> depositPool += amount;
            case 1000 -> depositPool += amount;
            default -> System.out.println("Invalid amount");
        }
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        return null;
    }

    @Override
    public int endSession() {
        int temp = depositPool;
        depositPool = 0;
        return temp;
    }

    @Override
    public String[] getDescription(int id) {
        String description = Arrays.toString(getProducts()) + "Beskrivning för ID: " + id;
        return new String[]{description};
    }

    @Override
    public String[] getProducts() {

        return new String[0];
    }
}
