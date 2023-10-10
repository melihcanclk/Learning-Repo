package com.melihcanclk.StudentAPISpringBoot.controllers;

import com.melihcanclk.StudentAPISpringBoot.handlers.NoStudentFoundException;
import com.melihcanclk.StudentAPISpringBoot.models.Student;
import com.melihcanclk.StudentAPISpringBoot.repositories.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    // constructor injection
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(
            path = "/{id}",
            produces = "application/json"
    )
    public Student getStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElseThrow(() -> new NoStudentFoundException(id));
    }

    @PostMapping(
            path = "",
            consumes = "application/json",
            produces = "application/json"
    )
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }
}
