package org.example;

public class Exercise3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(100);

        try {
            account.withdraw(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Uttag misslyckades: " + e.getMessage());
        }

        System.out.println("Saldo: " + account.getBalance());
    }
}

