
package com.hcl.model;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name,
                    String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Natural ordering: employee ID, ascending
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    // Employees with the same ID are considered equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee other)) {
            return false;
        }

        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Department: " + department
                + ", Salary: " + salary;
    }
}
