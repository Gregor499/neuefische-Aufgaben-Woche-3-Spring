package com.github.gregor499.neuefischeAufgabenWoche3Spring;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository students) {
        this.studentRepository = students;
    }

    public Optional<Student> getStudent(String id) {
        return studentRepository.getStudent(id);
    }

    public Collection<Student> getStudents() {
        return Collections.unmodifiableCollection(studentRepository.getStudents());
    }

    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }
}