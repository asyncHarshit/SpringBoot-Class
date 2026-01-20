package com.example.Day3_SMS.controller;


import com.example.Day3_SMS.model.StudentModel;
import com.example.Day3_SMS.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/students")
    public StudentModel addStudent(@RequestBody StudentModel student) {
        return service.addStudent(student);
    }
}

