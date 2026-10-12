package com.hcl.model;

public class Customer extends User {

    public Customer(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println("Customer [ID=" + getId() + ", Name=" + getName() + ", Email=" + getEmail() + "] - Role: Valued Customer (Standard Access)");
    }
}
