package com.demo.crm.model.builder;

import com.demo.crm.model.Mentor;

import java.time.LocalDate;

public class MentorBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dob;
    private Double salary;

    public static MentorBuilder builder() {
        return new MentorBuilder();
    }

    public MentorBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public MentorBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MentorBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MentorBuilder email(String email) {
        this.email = email;
        return this;
    }

    public MentorBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public MentorBuilder dob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public MentorBuilder salary(Double salary) {
        this.salary = salary;
        return this;
    }

    public Mentor build() {
        return new Mentor(id, firstName, lastName, email, phoneNumber, dob, salary);
    }

    @Override
    public String toString() {
        return "MentorBuilder{" +
                "salary=" + salary +
                '}';
    }
}
