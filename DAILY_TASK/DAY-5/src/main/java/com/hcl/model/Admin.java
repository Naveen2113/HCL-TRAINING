package com.hcl.model;

public class Admin extends User {

    public Admin(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println("Admin [ID=" + getId() + ", Name=" + getName() + ", Email=" + getEmail() + "] - Role: System Administrator (Full Access)");
    }
}
