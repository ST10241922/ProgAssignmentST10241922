/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainapp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        String userInput = JOptionPane.showInputDialog("Enter (1) to launch menu or any other key to exit:");

        if ("1".equals(userInput)) {
            showMenu();
        } else {
            System.out.println("Exiting Application.");
            System.exit(0);
        }
    }

    private static void showMenu() {
        while (true) {
            displayMainMenu();

            int choice;
            try {
                choice = Integer.parseInt(JOptionPane.showInputDialog("Enter your choice:"));
            } catch (NumberFormatException e) {
                System.out.println("Exiting Application.");
                System.exit(0);
                return;
            }

            switch (choice) {
                case 1:
                    captureStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    printStudentReport();
                    break;
                case 5:
                    System.out.println("Exiting Application.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid menu option.");
            }
        }
    }

    private static void displayMainMenu() {
        String menuText = "STUDENT MANAGEMENT APPLICATION\n" +
                "************************************************************\n" +
                "Please select one of the following menu items:\n" +
                "(1) Capture a new student.\n" +
                "(2) Search for a student.\n" +
                "(3) Delete a student.\n" +
                "(4) Print student report.\n" +
                "(5) Exit Application.";

        JOptionPane.showMessageDialog(null, menuText);
    }

    private static void captureStudent() {
        int age = 0; // Initialize age to 0

        while (age < 16) {
            String ageStr = JOptionPane.showInputDialog("Enter the student age:");
            if (ageStr == null) {
                return;
            }

            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You have entered an incorrect student age!");
            }

            if (age < 16) {
                JOptionPane.showMessageDialog(null, "Student age must be greater than or equal to 16.");
            }
        }

        String idStr = JOptionPane.showInputDialog("Enter the student id:");
        if (idStr == null) {
            return;
        }

        int studentID;
        try {
            studentID = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid student id.");
            return;
        }

        String name = JOptionPane.showInputDialog("Enter the student name:");
        if (name == null) {
            return;
        }

        String email = JOptionPane.showInputDialog("Enter the student email:");
        if (email == null) {
            return;
        }

        String course = JOptionPane.showInputDialog("Enter the student course:");
        if (course == null) {
            return;
        }

        Student student = new Student(studentID, name, age, email, course);
        studentList.add(student);

        JOptionPane.showMessageDialog(null, "Student details have been successfully saved.");
    }

    private static void searchStudent() {
        String idStr = JOptionPane.showInputDialog("Enter the student ID to search:");
        if (idStr == null) {
            return;
        }

        int studentID;
        try {
            studentID = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid student id.");
            return;
        }

        boolean found = false;
        for (Student student : studentList) {
            if (student.getStudentID() == studentID) {
                displayStudentInfo(student);
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Student with Student ID: " + studentID + " was not found!");
        }
    }

    private static void deleteStudent() {
        String idStr = JOptionPane.showInputDialog("Enter the student ID to delete:");
        if (idStr == null) {
            return;
        }

        int studentID;
        try {
            studentID = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid student id.");
            return;
        }

        boolean found = false;
        for (Student student : studentList) {
            if (student.getStudentID() == studentID) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete student " + studentID + " from the system?");
                if (option == JOptionPane.YES_OPTION) {
                    studentList.remove(student);
                    JOptionPane.showMessageDialog(null, "Student with Student ID: " + studentID + " was deleted!");
                } else {
                    JOptionPane.showMessageDialog(null, "Deletion canceled.");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Student with Student ID: " + studentID + " was not found!");
        }
    }

    private static void printStudentReport() {
        if (studentList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No students found in the system.");
        } else {
            StringBuilder report = new StringBuilder("STUDENT REPORT\n*********************************\n");
            for (Student student : studentList) {
                report.append("-----------------------------------\n");
                report.append("STUDENT ID: ").append(student.getStudentID()).append("\n");
                report.append("STUDENT name: ").append(student.getName()).append("\n");
                report.append("STUDENT age: ").append(student.getAge()).append("\n");
                report.append("STUDENT email: ").append(student.getEmail()).append("\n");
                report.append("STUDENT course: ").append(student.getCourse()).append("\n");
            }
            JOptionPane.showMessageDialog(null, report.toString());
        }
    }

    private static void displayStudentInfo(Student student) {
        StringBuilder info = new StringBuilder("-----------------------------------\n");
        info.append("STUDENT ID: ").append(student.getStudentID()).append("\n");
        info.append("STUDENT name: ").append(student.getName()).append("\n");
        info.append("STUDENT age: ").append(student.getAge()).append("\n");
        info.append("STUDENT email: ").append(student.getEmail()).append("\n");
        info.append("STUDENT course: ").append(student.getCourse()).append("\n");
        JOptionPane.showMessageDialog(null, info.toString());
    }
}

class Student {
    private int studentID;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(int studentID, String name, int age, String email, String course) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }
}
