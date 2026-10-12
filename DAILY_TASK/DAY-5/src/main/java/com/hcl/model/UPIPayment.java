
package com.hcl.model;

public class UPIPayment extends Payment implements Refundable {

    public UPIPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("UPI payment: Rs. " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("UPI refund: Rs. " + amount);
    }
}
