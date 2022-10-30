package com.demo.crm;

import com.demo.crm.model.CourseType;
import com.demo.crm.model.Mentor;
import com.demo.crm.model.Student;
import com.demo.crm.model.builder.CourseTypeBuilder;
import com.demo.crm.model.builder.MentorBuilder;
import com.demo.crm.model.builder.StudentBuilder;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.demo.crm.model.enums.CourseFormats.ONLINE;


public class Main {
    public static void main(String[] args) {

        Student student = StudentBuilder.builder().id(1L).dob(LocalDate.of(1999, 2, 25))
                .email("JohnD@gmail.com").firstName("John").lastName("Doe").phoneNumber("7182946")
                .build();
        Mentor mentor = MentorBuilder.builder().id(2L).email("Anne1987@gmail.com")
                .dob(LocalDate.of(1987, 7, 26))
                .firstName("Anne").lastName("Charlotte").phoneNumber("8546241")
                .build();
        CourseType coursetype = CourseTypeBuilder.builder().id(3L).typeName("English").durationOfCourse(12)
                .durationOfLesson(LocalTime.now()).lessonsPerWeek(12).pricePerMonth(20000.0).isOffline(true)
                .format(ONLINE).build();



        System.out.println(student);
        System.out.println(mentor);
        System.out.println(coursetype);
    }
}