package com.atm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // PIN authentication
        int correctPin = 1234;
        boolean authenticated = false;

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.print("Enter PIN: ");

            // Handle non-numeric PIN
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid PIN. Please enter numbers only.");
                scanner.next();
                attempt--;
                continue;
            }

            int pin = scanner.nextInt();

            if (pin == correctPin) {
                authenticated = true;
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Incorrect PIN.");
                System.out.println("Attempts remaining: " + (3 - attempt));
            }
        }

        // Block account after 3 incorrect attempts
        if (!authenticated) {
            System.out.println("Account blocked.");
            scanner.close();
            return;
        }

        // Account balance
        double balance = 5000;

        // Transaction history
        ArrayList<String> transactions = new ArrayList<>();
        transactions.add("Initial Balance: Rs.5000");

        int choice = 0;

        // ATM menu
        do {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Handle non-numeric menu choice
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Balance: Rs." + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount. Please enter a number.");
                        scanner.next();
                        continue;
                    }

                    double deposit = scanner.nextDouble();

                    if (deposit > 0) {
                        balance = balance + deposit;
                        transactions.add("Deposit: Rs." + deposit);

                        System.out.println("Deposit successful.");
                        System.out.println("New balance: Rs." + balance);
                    } else {
                        System.out.println("Invalid amount.");
                    }

                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount. Please enter a number.");
                        scanner.next();
                        continue;
                    }

                    double withdraw = scanner.nextDouble();

                    if (withdraw > 0 && withdraw <= balance) {
                        balance = balance - withdraw;
                        transactions.add("Withdrawal: Rs." + withdraw);

                        System.out.println("Withdrawal successful.");
                        System.out.println("Remaining balance: Rs." + balance);
                    } else {
                        System.out.println(
                                "Invalid amount or insufficient balance.");
                    }

                    break;

                case 4:
                    System.out.println("\n===== MINI STATEMENT =====");

                    // Enhanced for loop
                    for (String transaction : transactions) {
                        System.out.println(transaction);
                    }

                    break;

                case 5:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

        } while (choice != 5);

        scanner.close();
    }
}