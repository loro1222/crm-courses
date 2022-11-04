package com.demo.crm.service;

import com.demo.crm.model.CourseType;
import com.demo.crm.model.builder.CourseTypeBuilder;
import com.demo.crm.model.enums.CourseFormats;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CourseTypeService {
    private Scanner scanner;
    private static Long idCounter;

    static {
        idCounter = 0L;
    }

   public CourseTypeService() {
        this.scanner = new Scanner(System.in);
   }

   public CourseType create() {
       System.out.println("Creating course type...");

       System.out.println("Please, enter course type below.");
       System.out.print("Course type name: ");
       String typeName = scanner.nextLine();

       System.out.print("Duration fo course: ");
       Integer durationOfCourse = Integer.parseInt(scanner.nextLine());

       System.out.print("Duration of lesson (hour:minute): ");
       String durationOfLessonInString = scanner.nextLine();

       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
       LocalTime durationOfLesson = LocalTime.parse(durationOfLessonInString);

       System.out.print("How match lessons per week: ");
       Integer lessonsPerWeek = Integer.parseInt(scanner.nextLine());

       System.out.print("Price per month: ");
       Double pricePerMonth = Double.parseDouble(scanner.nextLine());

       System.out.print("Course offline or online: ");
       String isOffLineInString = scanner.nextLine();
       Boolean isOffLine = true;

       while (!(isOffLineInString.equals("online") || isOffLineInString.equals("offline"))) {
           if (isOffLineInString.equals("offline")) {
               isOffLine = true;
           } else {
               isOffLine = false;
           }
           System.out.println("You enter wrong type.");
           System.out.print("Please, reenter course offline of online: ");
           isOffLineInString = scanner.nextLine();
       }

       System.out.print("Course format: ");
       CourseFormats format = CourseFormats.valueOf(scanner.nextLine().trim().toUpperCase());

       return CourseTypeBuilder.builder()
               .id(++idCounter)
               .typeName(typeName)
               .durationOfCourse(durationOfCourse)
               .durationOfLesson(durationOfLesson)
               .lessonsPerWeek(lessonsPerWeek)
               .pricePerMonth(pricePerMonth)
               .isOffline(isOffLine)
               .format(format).build();

   }
}
