package com.hcl.service;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Executing Card Payment Strategy: debited Rs. " + amount + " from card account.");
    }
}
