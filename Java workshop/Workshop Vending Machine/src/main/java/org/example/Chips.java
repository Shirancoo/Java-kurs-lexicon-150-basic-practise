package org.example;

public class Chips extends Product {

    public Chips(int id, double price, String productName) {
        super(id, price, productName);
    }

    @Override
    public String examine() {
        return "OLW GrillChips : Har Ni Fest Eller? ";
    }

    @Override
    public String use() {
        return "Product " + getProductName() + " |" + " id: " +getId() + " | " + getPrice() + " kr ";
    }
}
