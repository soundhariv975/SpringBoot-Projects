package com.example.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.exception.StudentNotFoundException;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    // Register a new student
    public Student registerStudent(Student student) {
        students.add(student);
        return student;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Find student by ID
    public Student getStudentById(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        throw new StudentNotFoundException(
                "Student not found with ID: " + studentId);
    }

    // Delete student by ID
    public String deleteStudent(int studentId) {

        Student student = getStudentById(studentId);

        students.remove(student);

        return "Student deleted successfully";
    }
}

