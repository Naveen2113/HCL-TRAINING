package com.hcl.model;

public class Person {

    protected String name;

    // Package-private field
    String department;

    public Person(String name) {
        this.name = name;
        this.department = "Computer Science";
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}