package com.example.day1_revison;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/")
    public String Hello(){
        return "This is the First Line";
    }
    @GetMapping("/getDetail")
    public String GetDetail(){
        return "This is our new Train Detail";
    }
    @GetMapping("/getData")
    public String GetData(){
        return "This is student Details";
    }
}
