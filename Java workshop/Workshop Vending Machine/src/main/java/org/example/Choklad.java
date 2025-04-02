package org.example;

public class Choklad extends Product {


    public Choklad(int id, double price, String productName) {
        super(id, price, productName);
    }

    @Override
    public String examine() {
        return "Snickers: You're not you when you're hungry" ;
    }

    @Override
    public String use() {
        return "Product " + getProductName() + " |" + " id: " +getId() + " | " + getPrice() + " kr ";
    }
}
