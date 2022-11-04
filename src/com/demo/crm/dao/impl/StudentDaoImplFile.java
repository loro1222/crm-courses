package com.demo.crm.dao.impl;

import com.demo.crm.dao.StudentDao;
import com.demo.crm.model.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class StudentDaoImplFile implements StudentDao {

    private File pathToFile;
    private File pathToFolder;

    public StudentDaoImplFile() {
        pathToFolder = new File("C:\\Users\\mruma\\Java_Course\\IdeaProjects\\files\\crm");
        pathToFile = new File(pathToFolder + "\\student.txt");

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
    public Student save(Student student) {
        try {
            FileWriter fileWriter = new FileWriter(pathToFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(student.getId());
            printWriter.println(student.getFirstName());
            printWriter.println(student.getLastName());
            printWriter.println(student.getEmail());
            printWriter.println(student.getPhoneNumber());
            printWriter.println(student.getDob());

            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public Student find(Long id) {
        Student student = null;
        try {
            Scanner scanner = new Scanner(pathToFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine(); // "1"
                if (line.trim().equals(String.valueOf(id))) {
                    student = new Student();
                    student.setId(Long.parseLong(line));
                    student.setFirstName(scanner.nextLine());
                    student.setLastName(scanner.nextLine());
                    student.setEmail(scanner.nextLine());
                    student.setPhoneNumber(scanner.nextLine());
                    student.setDob(LocalDate.parse(scanner.nextLine()));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
