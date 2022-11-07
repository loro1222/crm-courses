package com.demo.crm.dao.impl;

import com.demo.crm.dao.CourseDao;
import com.demo.crm.model.Course;
import com.demo.crm.model.CourseType;
import com.demo.crm.model.enums.CourseFormats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class CourseDaoImplFile implements CourseDao {
    private File pathToFolder;
    private File pathToFile;

    public CourseDaoImplFile() {
        pathToFolder = new File("C:\\Users\\mruma\\Java_Course\\IdeaProjects\\files\\crm");
        pathToFile = new File(pathToFolder + "course.txt");

        if (!pathToFolder.exists()) {
            pathToFolder.mkdirs();
        }

        if (!pathToFile.exists()) {
            try {
                pathToFile.createNewFile();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @Override
    public Course save(Course course) {
        try {
            FileWriter fileWriter = new FileWriter(pathToFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(course.getId());
            printWriter.println(course.getCourseName());
            printWriter.println(course.getCourseType());
            printWriter.println(course.getCreateDate());

            printWriter.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return course;
    }

    @Override
    public Course find(Long id) {
        Course course = null;
        try {
            Scanner scanner = new Scanner(pathToFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.trim().equals(String.valueOf(id))) {
                    course.setId(Long.parseLong(scanner.nextLine()));
                    course.setCourseName(scanner.nextLine());

                    CourseType courseType = null;
                    courseType.setId(Long.parseLong(scanner.nextLine()));
                    courseType.setTypeName(scanner.nextLine());
                    courseType.setDurationOfCourse(Integer.parseInt(scanner.nextLine()));
                    courseType.setDurationOfLesson(LocalTime.parse(scanner.nextLine()));
                    courseType.setLessonsPerWeek(Integer.parseInt(scanner.nextLine()));
                    courseType.setPricePerMonth(Double.parseDouble(scanner.nextLine()));
                    courseType.setOffline(Boolean.parseBoolean(scanner.nextLine()));
                    courseType.setFormat(CourseFormats.valueOf(scanner.nextLine()));

                    course.setCourseType((courseType));
                }
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return course;
    }
}
