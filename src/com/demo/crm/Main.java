package com.demo.crm;

import com.demo.crm.model.Mentor;
import com.demo.crm.model.Student;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        Student student = StudentBuilder.builder().id(1L).dob(LocalDate.now()).firstName("John").lastName("Doe")
                .build();
git
=======
        Student student = new Student();
        Mentor mentor = new Mentor();

>>>>>>> parent of 226e23b (Main class added)
        System.out.println(student);
    }
}