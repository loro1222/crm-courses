package com.demo.crm.service;

import com.demo.crm.model.Course;
import com.demo.crm.model.CourseType;
import com.demo.crm.model.builder.CourseBuilder;
import com.demo.crm.model.enums.CourseFormats;

import java.util.Scanner;

public class CourseService {
    private Scanner scanner;

    private static Long idCounter;

    static {
        idCounter = 0L;
    }

    public CourseService() {
        this.scanner = new Scanner(System.in);
    }

    public Course create() {
        System.out.println("Creating course... ");

        System.out.print("Please, enter course data below.");
        String courseName = scanner.nextLine();

        System.out.print("Course type: ");
        CourseType courseType;

        return null;
    }

}
