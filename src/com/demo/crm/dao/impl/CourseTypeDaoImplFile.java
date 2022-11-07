package com.demo.crm.dao.impl;

import com.demo.crm.dao.CourseTypeDao;
import com.demo.crm.model.CourseType;
import com.demo.crm.model.enums.CourseFormats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class CourseTypeDaoImplFile implements CourseTypeDao {
    private File pathToFolder;
    private File pathToFile;

    public CourseTypeDaoImplFile() {
        pathToFolder = new File("C:\\Users\\mruma\\Java_Course\\IdeaProjects\\files\\crm"); //C:\\Users\\mruma\\Java_Course\\IdeaProjects\\files\\crm"
        pathToFile = new File(pathToFolder + "coursetype.txt");

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
    public CourseType save(CourseType courseType) {
        try {
            FileWriter fileWriter = new FileWriter(pathToFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(courseType.getId());
            printWriter.println(courseType.getTypeName());
            printWriter.println(courseType.getDurationOfCourse());
            printWriter.println(courseType.getDurationOfLesson());
            printWriter.println(courseType.getLessonsPerWeek());
            printWriter.println(courseType.getPricePerMonth());
            printWriter.println(courseType.getOffline());
            printWriter.println(courseType.getFormat());

            printWriter.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return null;
    }

    @Override
    public CourseType find(Long id) {
        CourseType courseType = null;
        try {
            Scanner scanner = new Scanner(pathToFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.trim().equals(String.valueOf(id))) {
                    courseType.setId(Long.parseLong(scanner.nextLine()));
                    courseType.setTypeName(scanner.nextLine());
                    courseType.setDurationOfCourse(Integer.parseInt(scanner.nextLine()));
                    courseType.setDurationOfLesson(LocalTime.parse(scanner.nextLine()));
                    courseType.setLessonsPerWeek(Integer.parseInt(scanner.nextLine()));
                    courseType.setPricePerMonth(Double.parseDouble(scanner.nextLine()));
                    courseType.setOffline(Boolean.parseBoolean(scanner.nextLine()));
                    courseType.setFormat(CourseFormats.valueOf(scanner.nextLine()));
                }
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return courseType;
    }
}
