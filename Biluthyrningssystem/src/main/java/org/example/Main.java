package org.example;

public class Main {
    public static void main(String[] args) {

        Car volvo = new Car("Volvo","740",250,true,CarType.SUV);

        System.out.println(volvo.isÄrInne());
        volvo.returnCar();
        volvo.rent();
        System.out.println(volvo.isÄrInne());





    }
}