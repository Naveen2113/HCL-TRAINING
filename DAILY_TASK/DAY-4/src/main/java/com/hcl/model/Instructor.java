package com.hcl.model;

public class Instructor {

    private int instructorId;
    private String instructorName;
    private String email;

    public Instructor(int instructorId, String instructorName, String email) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.email = email;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getEmail() {
        return email;
    }
}