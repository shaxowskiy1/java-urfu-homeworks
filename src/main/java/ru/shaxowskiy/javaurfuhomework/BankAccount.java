package ru.shaxowskiy.javaurfuhomework;

public class BankAccount implements AccountActions{
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new RuntimeException("amount should be positive");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount > balance) {
            throw new RuntimeException("not enough money at balance");
        } else {
            throw new RuntimeException("amount should be positive");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
