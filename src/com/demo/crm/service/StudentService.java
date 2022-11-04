package com.demo.crm.service;

import com.demo.crm.dao.StudentDao;
import com.demo.crm.dao.impl.StudentDaoImplFile;
import com.demo.crm.model.Student;
import com.demo.crm.model.builder.StudentBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StudentService {

    private Scanner scanner;
    private static Long idCounter;
    private StudentDao studentDao;

    static {
        System.out.println("Static block initialized");
        idCounter = 0L;
    }

    public StudentService() {
        System.out.println("Student service constructor invoked");
        this.scanner = new Scanner(System.in);
        this.studentDao = new StudentDaoImplFile();
    }

    public Student create() {
        System.out.println("Creating student...");

        System.out.println("Please, enter student data below.");
        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Date of birth(dd.MM.yyyy): ");
        String dobInString = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dob = LocalDate.parse(dobInString, formatter);

        return studentDao.save(StudentBuilder.builder().id(++idCounter)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .dob(dob).build());
    }

    public Student find(Long id) {
        return studentDao.find(id);
    }
}
