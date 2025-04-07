package Markus.org;

public class Main {
    public static void main(String[] args) {
        Person kalle = new Person("null", "ssss", "Persson@gmail.com");
        Person markus = new Person("Markus", "Agersten", "");
        Person marksus = new Person("Markus", "Agersten", "");


        System.out.println(kalle.getSummary());
        System.out.println(markus.getSummary());
        System.out.println(marksus.getSummary());



    }

}