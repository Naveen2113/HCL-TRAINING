package com.hcl.service;

public class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Executing UPI Payment Strategy: transferred Rs. " + amount + " via UPI VPA.");
    }
}
