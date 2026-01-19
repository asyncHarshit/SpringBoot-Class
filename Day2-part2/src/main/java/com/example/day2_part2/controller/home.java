package com.example.day2_part2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class home {

    @GetMapping("/about")
    public String about(){
        return "this is the about page";
    }

}
