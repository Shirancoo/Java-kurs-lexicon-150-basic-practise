package Markus.org;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        double balance = 0;


        boolean isRunning = true;


        while (isRunning) {
            System.out.println("*************");
            System.out.println("What do you want to do: Press 1-4");
            System.out.println("*************");
            System.out.println("showBalance");
            System.out.println("Deposit");
            System.out.println("Withdraw");
            System.out.println("exit");
            System.out.println("*************");
            String option = input.next();

            switch (option) {

                case "1" -> showBalance(balance);
                case "2" -> balance += deposit();
                case "3" -> balance -= withdraw();
                case "4" -> isRunning = false;
                default -> System.out.println("Invalid choise");

            }
        }

    }

    static void showBalance(double balance) {
        System.out.printf("$%.2f\n", balance);
    }

    static double deposit() {
        double amount;
        System.out.println("Enter how much you want to deposit");
        amount = input.nextDouble();
        if (amount < 0) {
            System.out.println("amount cant be negative");
            return 0;
        }
        return amount;
    }

    static double withdraw() {
        double cashout;
        System.out.println("Enter how much you want to withdraw");
        cashout = input.nextDouble();
        if (cashout < 0) {
            System.out.println("Withdraw cant be negative");
            return 0;
        }
        return cashout;
    }


}