package com.demo.crm.dao.impl;

import com.demo.crm.dao.MentorDao;
import com.demo.crm.model.Mentor;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MentorDaoImplFile implements MentorDao {
    private File pathToFolder;
    private File pathToFile;

    public MentorDaoImplFile() {
        pathToFolder = new File("C:\\Users\\mruma\\Java_Course\\IdeaProjects\\files\\crm");
        pathToFile = new File(pathToFolder + "mentors.txt");

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
    public Mentor save(Mentor mentor) {
        try {
            FileWriter fileWriter = new FileWriter(pathToFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(mentor.getId());
            printWriter.println(mentor.getFirstName());
            printWriter.println(mentor.getLastName());
            printWriter.println(mentor.getEmail());
            printWriter.println(mentor.getPhoneNumber());
            printWriter.println(mentor.getDob());
            printWriter.println(mentor.getCreateDate());
            printWriter.println(mentor.getSalary());

            printWriter.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return mentor;
    }

    @Override
    public Mentor find(Long id) {
        Mentor mentor = null;
        try {
            Scanner scanner = new Scanner(pathToFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.trim().equals(String.valueOf(id))) {
                    mentor = new Mentor();
                    mentor.setId(Long.parseLong(line));
                    mentor.setFirstName(scanner.nextLine());
                    mentor.setLastName(scanner.nextLine());
                    mentor.setEmail(scanner.nextLine());
                    mentor.setPhoneNumber(scanner.nextLine());
                    mentor.setDob(LocalDate.parse(scanner.nextLine()));
                    mentor.setCreateDate(LocalDateTime.parse(scanner.nextLine()));
                    mentor.setSalary(Double.parseDouble(scanner.nextLine()));
                }
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return mentor;
    }
}
