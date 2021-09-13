package com.sharmarajdaksh;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;
    private int typeOfAccount;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.typeOfAccount = typeOfAccount;
    }

    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch) {
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return this.typeOfAccount == BankAccount.CHECKING;
    }
}
