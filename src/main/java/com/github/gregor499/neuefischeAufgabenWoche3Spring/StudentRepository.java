package com.github.gregor499.neuefischeAufgabenWoche3Spring;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
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
