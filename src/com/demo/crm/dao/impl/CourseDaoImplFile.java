package com.demo.crm.dao.impl;

import com.demo.crm.dao.CourseDao;
import com.demo.crm.dao.CourseTypeDao;
import com.demo.crm.model.Course;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CourseDaoImplFile implements CourseDao {
    private File pathToFolder;
    private File pathToFileCourse;

    public CourseDaoImplFile() {
        pathToFolder = new File("C:\\Users\\mruma\\Java_Course\\IdeaProjects\\files\\crm");
        pathToFileCourse = new File(pathToFolder + "course.txt");

        if (!pathToFolder.exists()) {
            pathToFolder.mkdirs();
        }

        if (!pathToFileCourse.exists()) {
            try {
                pathToFileCourse.createNewFile();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    @Override
    public Course save(Course course) {
        try {
            FileWriter fileWriter = new FileWriter(pathToFileCourse, true);
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
    public Course find(Long courseId, Long courseTypeId) {
        Course course = null;
        try {
            Scanner scanner = new Scanner(pathToFileCourse);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.trim().equals(String.valueOf(courseId))) {
                    course.setId(Long.parseLong(scanner.nextLine()));
                    course.setCourseName(scanner.nextLine());

                    CourseTypeDao courseTypeDao = new CourseTypeDaoImplFile();
                    course.setCourseType((courseTypeDao.find(courseTypeId)));
                }
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return course;
    }
}
