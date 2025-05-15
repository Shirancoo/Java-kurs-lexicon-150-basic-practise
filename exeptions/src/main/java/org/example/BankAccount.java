package org.example;

    class BankAccount {
        private double balance = 0;

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                throw new IllegalArgumentException("Otillräckligt saldo.");
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

