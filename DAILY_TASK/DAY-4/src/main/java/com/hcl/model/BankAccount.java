package com.hcl.model;

import java.util.Objects;

public class BankAccount {

    // Private fields - Encapsulation
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Static counter
    private static int accountCounter = 0;

    // Constructor 1
    public BankAccount() {
        this("UNKNOWN", "UNKNOWN", 0.0);
    }

    // Constructor 2
    public BankAccount(String accountNumber, String accountHolder) {
        this(accountNumber, accountHolder, 0.0);
    }

    // Constructor 3
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;

        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.balance = balance;
        accountCounter++;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero"
            );
        }

        balance += amount;
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero"
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "Insufficient balance"
            );
        }

        balance -= amount; // 
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Static getter
    public static int getAccountCounter() {
        return accountCounter;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BankAccount)) {
            return false;
        }

        BankAccount other = (BankAccount) obj;

        return Objects.equals(
                accountNumber,
                other.accountNumber
        );
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}