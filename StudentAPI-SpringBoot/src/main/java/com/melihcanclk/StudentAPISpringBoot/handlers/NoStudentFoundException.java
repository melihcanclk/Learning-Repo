package com.melihcanclk.StudentAPISpringBoot.handlers;

public class NoStudentFoundException extends RuntimeException{
    public NoStudentFoundException(Long id) {
        super("Student with id " + id + " not found.");
    }
}
