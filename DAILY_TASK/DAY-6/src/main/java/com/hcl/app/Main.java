
package com.hcl.app;

import java.util.Scanner;

import com.hcl.service.OrderProcessor;
import com.hcl.exception.InsufficientStockException;
import com.hcl.exception.InvalidQuantityException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OrderProcessor processor = new OrderProcessor();

        boolean running = true;

        while (running) {
            System.out.println("\n===== ORDER PROCESSOR =====");
            System.out.println("1. Place Order");
            System.out.println("2. View Stock");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        try {
                            processor.processOrder(quantity);
                        } catch (InsufficientStockException e) {
                            System.out.println(
                                    "Handled stock error: " + e.getMessage());
                        } catch (InvalidQuantityException e) {
                            System.out.println(
                                    "Handled quantity error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println(
                                "Available stock: " + processor.getStock());
                        break;

                    case 3:
                        running = false;
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid menu choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a valid number.");
            }
        }

        scanner.close();
    }
}
