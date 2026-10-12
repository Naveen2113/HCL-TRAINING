
package com.hcl.model;

public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // Abstract method
    public abstract void pay();

    // Method overloading - first version
    public void pay(double amount) {
        System.out.println("Payment amount: Rs. " + amount);
    }

    // Method overloading - second version
    public void pay(double amount, String currency) {
        System.out.println("Payment: " + currency + " " + amount);
    }

    public double getAmount() {
        return amount;
    }
}
