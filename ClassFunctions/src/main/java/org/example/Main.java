package org.example;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Vampire vampire = new Vampire(100,"Vampire");
        MainCharacter markus = new MainCharacter(1, 5, 4);
        Boolean isRunning = true;

        while (isRunning) {
            System.out.println("---------------------");
            System.out.println("Welcome to my game vampire against human");
            System.out.println("Type 1 to start game");
            int choise = input.nextInt();

            if (choise == 1) {
                System.out.println(  vampire.getHealth() -  markus.getDamage() );
                System.out.println(vampire.health);
            }

        }


    }
}