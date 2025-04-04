package org.example;

public class Main {
    public static void main(String[] args) {


        BankAccount account1 = new BankAccount(500,"Markus","Markus@hotmail.com","0768028136");
        account1.setCostumerName("kalle");
        account1.setAccountBalance(500);
        System.out.println(account1.getAccountBalance());
        account1.withdraw(5);
        System.out.println(account1.getAccountBalance());
        account1.depositing(525);
        System.out.println(account1.getAccountBalance());
        account1.getBankInfo();

    }
}