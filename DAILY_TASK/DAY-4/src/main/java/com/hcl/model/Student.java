package com.hcl.model;

public class Student extends Person {

    private int studentId;
    private String course;

    public Student(String name, String course) {
        super(name);
        this.course = course;
    }

    public Student(int studentId, String name, String course) {
        super(name);
        this.studentId = studentId;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public void displayStudent() {
        super.display();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}