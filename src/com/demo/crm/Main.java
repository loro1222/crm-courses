package com.demo.crm;

import com.demo.crm.model.Student;
import com.demo.crm.model.builder.StudentBuilder;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Student student = StudentBuilder.builder().id(1L).dob(LocalDate.now()).firstName("John").lastName("Doe")
                .build();

        System.out.println(student);
    }
}