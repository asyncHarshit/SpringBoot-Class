package com.example.day2_part2.controller;

import com.example.day2_part2.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class home {

    @GetMapping("/")
    public StudentModel getStudent(){
        return new StudentModel("1" , "Harshit" , "harshit@gmail.com");
    }

}
