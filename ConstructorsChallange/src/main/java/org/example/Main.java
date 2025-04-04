package org.example;

public class Main {
    public static void main(String[] args) {


        Customer kalle = new Customer();
        Customer alle = new Customer("kalle@hotmail.com", "kalle");

        System.out.println(kalle.getCreditLimit() + " " + kalle.getName() + " " + kalle.getEmailAdress());
        System.out.println(alle.getCreditLimit() + " " + alle.getName() + " " + alle.getEmailAdress());

    }
}