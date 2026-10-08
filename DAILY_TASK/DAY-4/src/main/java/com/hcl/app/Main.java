package com.hcl.app;

import com.hcl.model.BankAccount;
import com.hcl.service.AccountService;

public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount("ACC1001", "Naveen", 5000);

        AccountService service = new AccountService();

        System.out.println("===== BANK ACCOUNT =====");

        System.out.println("\nInitial Account:");
        service.displayAccount(account);

        service.deposit(account, 1000);

        System.out.println("\nAfter Deposit:");
        service.displayAccount(account);

        service.withdraw(account, 2000);

        System.out.println("\nAfter Withdrawal:");
        service.displayAccount(account);

        System.out.println("\nTotal Accounts Created: "
                + BankAccount.getAccountCounter());
    }
}