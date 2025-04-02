package Markus.org;

public class Main {
    public static void main(String[] args) {
        Person kalle = new Person(14,"kalle","agersten","kallemurare@gmail.com");
        Person markus = new Person(13,"markus","agersten","Markus@gmail.com");



        System.out.println(kalle.getSummay());

        System.out.println(markus.getSummay());
        markus.seteMail("");
        System.out.println(markus.getId());



    }

}