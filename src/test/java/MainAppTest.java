/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainAppTest {

    @Test
    void testSaveStudent() {
        Student student = new Student(1, "John Doe", 20, "john@example.com", "Computer Science");
        StudentManagementApplication.saveStudent(student);
        assertTrue(StudentManagementApplication.studentList.contains(student));
    }

    @Test
    void testSearchStudent() {
        Student student = new Student(2, "Jane Doe", 22, "jane@example.com", "Mathematics");
        StudentManagementApplication.saveStudent(student);
        Student foundStudent = StudentManagementApplication.searchStudent(2);
        assertEquals(student, foundStudent);
    }

    @Test
    void testSearchStudent_StudentNotFound() {
        Student student = new Student(3, "Bob Smith", 25, "bob@example.com", "Physics");
        Student foundStudent = StudentManagementApplication.searchStudent(999); // Non-existent ID
        assertNull(foundStudent);
    }

    @Test
    void testDeleteStudent() {
        Student student = new Student(4, "Alice Johnson", 21, "alice@example.com", "Chemistry");
        StudentManagementApplication.saveStudent(student);
        StudentManagementApplication.deleteStudent(4);
        assertFalse(StudentManagementApplication.studentList.contains(student));
    }

    @Test
    void testDeleteStudent_StudentNotFound() {
        Student student = new Student(5, "Charlie Brown", 24, "charlie@example.com", "Biology");
        StudentManagementApplication.saveStudent(student);
        StudentManagementApplication.deleteStudent(999); // Non-existent ID
        assertTrue(StudentManagementApplication.studentList.contains(student));
    }

    @Test
    void testStudentAge_StudentAgeValid() {
        boolean isValid = StudentManagementApplication.isStudentAgeValid(18);
        assertTrue(isValid);
    }

    @Test
    void testStudentAge_StudentAgeInvalid() {
        boolean isValid = StudentManagementApplication.isStudentAgeValid(15);
        assertFalse(isValid);
    }

    @Test
    void testStudentAge_StudentAgeInvalidCharacter() {
        boolean isValid = StudentManagementApplication.isStudentAgeValid("abc"); // Invalid character
        assertFalse(isValid);
    }
}

