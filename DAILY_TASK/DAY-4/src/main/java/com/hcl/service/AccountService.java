package com.hcl.service;

import com.hcl.model.BankAccount;

public class AccountService {

    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(BankAccount account, double amount) {
        account.withdraw(amount);
    }

    public void displayAccount(BankAccount account) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: " + account.getBalance());
    }
}