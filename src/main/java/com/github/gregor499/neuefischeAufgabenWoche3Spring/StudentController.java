package com.github.gregor499.neuefischeAufgabenWoche3Spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping
    public Student getStudent(){
        return new Student("Max", "Mustermann");
    }

    //@PostMapping

}
