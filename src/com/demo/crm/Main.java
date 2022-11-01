package com.demo.crm;

import com.demo.crm.model.Student;
import com.demo.crm.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService(); //
        Student student = studentService.create();

        StudentService studentService1 = new StudentService();
        Student student1 = studentService1.create();


        System.out.println(student);
        System.out.println(student1);
    }
}