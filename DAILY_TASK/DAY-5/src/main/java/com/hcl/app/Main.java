package com.hcl.app;

import com.hcl.model.Admin;
import com.hcl.model.CardPayment;
import com.hcl.model.CashPayment;
import com.hcl.model.Customer;
import com.hcl.model.Payment;
import com.hcl.model.Refundable;
import com.hcl.model.UPIPayment;
import com.hcl.model.User;
import com.hcl.service.CardPaymentStrategy;
import com.hcl.service.PaymentStrategy;
import com.hcl.service.UPIPaymentStrategy;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // 1. PAYMENT SYSTEM (INHERITANCE & POLYMORPHISM)
        // ==========================================
        Payment card = new CardPayment(2000);
        Payment upi = new UPIPayment(1500);
        Payment cash = new CashPayment(500);

        System.out.println("=== PAYMENT SYSTEM [Feature Student-A: Enabled Audit Logging] ===");
        card.pay();
        upi.pay();
        cash.pay();

        // ==========================================
        // 2. METHOD OVERLOADING
        // ==========================================
        System.out.println("\n=== METHOD OVERLOADING ===");
        card.pay(3000);
        card.pay(100, "USD");

        // ==========================================
        // 3. INTERFACE (REFUNDABLE)
        // ==========================================
        System.out.println("\n=== REFUND ===");
        Refundable refundable = (Refundable) card;
        refundable.refund(500);

        // ==========================================
        // 4. RUNTIME POLYMORPHISM (PAYMENT HIERARCHY)
        // ==========================================
        System.out.println("\n=== RUNTIME POLYMORPHISM ===");
        Payment[] payments = {card, upi, cash};
        for (Payment payment : payments) {
            payment.pay();
        }

        // ==========================================
        // 5. USER & ROLE HIERARCHY (ADVANCED OOP)
        // ==========================================
        System.out.println("\n=== USER ROLE HIERARCHY ===");
        User admin = new Admin(101, "Alice Admin", "admin.alice@hcl.com");
        User customer = new Customer(202, "Bob Customer", "customer.bob@hcl.com");

        User[] users = {admin, customer};
        for (User user : users) {
            // Polymorphic call to displayRole()
            user.displayRole();
        }

        // ==========================================
        // 6. STRATEGY PATTERN (PAYMENT STRATEGY)
        // ==========================================
        System.out.println("\n=== STRATEGY PATTERN ===");
        PaymentStrategy strategy;

        // Card Payment Strategy execution
        strategy = new CardPaymentStrategy();
        strategy.pay(4500.0);

        // UPI Payment Strategy execution
        strategy = new UPIPaymentStrategy();
        strategy.pay(2500.0);
    }
}
