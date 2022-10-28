package com.demo.crm.model.builder;

import com.demo.crm.model.Student;

import java.time.LocalDate;

public class StudentBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dob;

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public StudentBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public StudentBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder email(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public StudentBuilder dob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public Student build() {
        return new Student(id, firstName, lastName, email, phoneNumber, dob);
    }

}
