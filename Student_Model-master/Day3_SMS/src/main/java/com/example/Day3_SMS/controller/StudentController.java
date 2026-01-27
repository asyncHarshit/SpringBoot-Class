package com.example.Day3_SMS.controller;


import com.example.Day3_SMS.model.StudentModel;
import com.example.Day3_SMS.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/students")
    public List<StudentModel> getStudents(){
        return service.getStudents();
    }



}

