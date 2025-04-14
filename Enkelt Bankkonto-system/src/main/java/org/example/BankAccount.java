package org.example;

public class BankAccount implements Transactable {
    private double saldo;
    private String accountHolder;

    public BankAccount(double saldo, String accountHolder) {
        this.saldo = saldo;
        this.accountHolder = accountHolder;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }


    @Override
    public double deposit(double deposit) {
        if (deposit > 0)
            saldo += deposit;
        else {
            System.out.println("need to be positive amount");
        }
        return deposit;

    }


    @Override
    public double withdraw(double amountWithdrawn) {
        if (amountWithdrawn > 0 && amountWithdrawn <= saldo) {
            saldo -= amountWithdrawn;
        }
        else System.out.println("you don't have that amount to withdraw");
        return amountWithdrawn;
    }
}

