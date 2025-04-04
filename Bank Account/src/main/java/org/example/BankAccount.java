package org.example;

public class BankAccount {
    private String accountNumber;
    private double accountBalance;
    private String costumerName;
    private String email;
    private String phoneNumber;




    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public void getBankInfo() {
        System.out.println(getEmail() + "  " + getCostumerName() + "  " + getPhoneNumber());
    }

    public void depositing(double deposit) {
        if (deposit <= 0)
            System.out.println("You cannot deposit less than 1 Kr");
        else
            System.out.println("You did deposit " + deposit + " your new balance is " + (accountBalance += deposit) + "Kr");


    }

    public void withdraw(double draw) {
        if (draw >= this.accountBalance || draw <= 0)
            System.out.println("You cannot withdraw more than " + this.accountBalance + " Kr");
        else
            System.out.println("You did Withdraw " + (draw) + "Kr\nYour new balance is\n" + (this.accountBalance -= draw) + "Kr");
    }

    public BankAccount(double accountBalance, String costumerName, String email, String phoneNumber) {
        this.accountBalance = accountBalance;
        this.costumerName = costumerName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }


}



