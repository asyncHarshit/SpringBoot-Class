package com.example.day2_part2.controller;

import com.example.day2_part2.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/")
    public List<StudentModel> getStudents() {
        List<StudentModel> arr = new ArrayList<>();

        arr.add(new StudentModel("1", "Harshit", "harshit@gmail.com"));
        arr.add(new StudentModel("2", "Rahul", "rahul@gmail.com"));
        arr.add(new StudentModel("3", "Ankit", "ankit@gmail.com"));

        return arr;
    }
}
