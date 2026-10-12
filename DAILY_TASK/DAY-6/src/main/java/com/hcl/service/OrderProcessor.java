
package com.hcl.service;

import com.hcl.exception.InsufficientStockException;
import com.hcl.exception.InvalidQuantityException;

public class OrderProcessor {

    private int stock = 10;

    public void processOrder(int quantity)
            throws InsufficientStockException {

        try {
            System.out.println("\nProcessing order for quantity: " + quantity);

            // Business rule 1: Quantity must be positive
            if (quantity <= 0) {
                throw new InvalidQuantityException(
                        "Quantity must be greater than zero.");
            }

            // Business rule 2: Quantity cannot exceed stock
            if (quantity > stock) {
                throw new InsufficientStockException(
                        "Insufficient stock. Available stock: " + stock);
            }

            stock -= quantity;

            System.out.println("Order successful!");
            System.out.println("Items ordered: " + quantity);
            System.out.println("Remaining stock: " + stock);

        } catch (InvalidQuantityException | InsufficientStockException e) {
            System.out.println("Order failed: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("AUDIT: Order processing attempt completed.");
        }
    }

    public int getStock() {
        return stock;
    }

    // Exception chaining demonstration
    public void demonstrateExceptionChaining() {
        try {
            throw new IllegalStateException(
                    "Simulated low-level inventory failure.");
        } catch (IllegalStateException e) {
            throw new RuntimeException(
                    "Unable to complete inventory operation.", e);
        }
    }
}
