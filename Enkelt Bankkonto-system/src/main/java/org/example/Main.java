package org.example;

public class Main {
    public static void main(String[] args) {

    BankAccount account1 = new BankAccount(500,"kalle");
        System.out.println(account1.getSaldo());
        account1.deposit(5);
        System.out.println(account1.getSaldo());
        account1.withdraw(508);
        System.out.println(account1.getSaldo());




        }
    }
