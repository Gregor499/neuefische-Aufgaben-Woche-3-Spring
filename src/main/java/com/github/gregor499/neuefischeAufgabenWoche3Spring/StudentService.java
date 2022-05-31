package com.github.gregor499.neuefischeAufgabenWoche3Spring;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final Map<String, Student> students = new HashMap<>();

    public Optional<Student> getStudent(String id) {
        return Optional.ofNullable(students.get(id));
    }

    public Collection<Student> getStudents() {
        return Collections.unmodifiableCollection(students.values());
    }

    public void createStudent(Student student) {
        students.put(student.getId(), student);
    }
}