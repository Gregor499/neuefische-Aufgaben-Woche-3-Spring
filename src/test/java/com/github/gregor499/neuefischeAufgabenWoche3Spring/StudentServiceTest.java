package com.github.gregor499.neuefischeAufgabenWoche3Spring;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class StudentServiceTest {

    @Test
    void shouldReturnStudentId(){
        Student student1 = new Student("Müller", "Max");
        Student student2 = new Student ("Garrels", "Uwe");
        StudentRepository studentRepository = mock(StudentRepository.class);
        when(studentRepository.getStudent("4711")).thenReturn(Optional.of(student1));

        StudentService studentService = new StudentService(studentRepository);

        Optional <Student> actual = studentService.getStudent("4711");

        assertThat(actual).contains(student1);
    }

    @Test
    void shouldReturnEmptyIfStudentNotFound(){
        Student student1 = new Student("Müller", "Max");
        Student student2 = new Student ("Garrels", "Uwe");
        StudentRepository studentRepository = mock(StudentRepository.class);
        when(studentRepository.getStudent("4711")).thenReturn(Optional.of(student1));

        StudentService studentService = new StudentService(studentRepository);

        Optional <Student> actual = studentService.getStudent("");

        assertThat(actual).isEmpty();
    }

    @Test
    void shouldReturnStudents(){
        Student student1 = new Student("Müller", "Max");
        Student student2 = new Student ("Garrels", "Uwe");
        StudentRepository studentRepository = mock(StudentRepository.class);
        when(studentRepository.getStudents()).thenReturn(List.of(student1, student2));

        StudentService studentService = new StudentService(studentRepository);

        Collection <Student> actual = studentService.getStudents();

        assertThat(actual).isUnmodifiable().contains(student1, student2);
    }

    @Test
    void shouldProofIfDeployedCreatedStudent(){
        Student student1 = new Student("Müller", "Max");
        Student student2 = new Student ("Garrels", "Uwe");
        StudentRepository studentRepository = mock(StudentRepository.class);
        StudentService studentService = new StudentService(studentRepository);

        studentService.createStudent(student1);

        verify(studentRepository).createStudent(student1);
    }

}
