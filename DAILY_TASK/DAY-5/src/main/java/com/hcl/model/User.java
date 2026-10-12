package com.hcl.model;

public class User extends BaseEntity {

    private String name;
    private String email;

    public User(int id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void displayRole() {
        System.out.println("User [ID=" + getId() + ", Name=" + name + ", Email=" + email + "] - Role: Standard User");
    }
}
