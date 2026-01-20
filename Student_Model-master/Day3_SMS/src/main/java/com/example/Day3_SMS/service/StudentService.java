package com.example.Day3_SMS.service;

import com.example.Day3_SMS.model.StudentModel;
import com.example.Day3_SMS.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final  StudentRepository repository;


    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentModel addStudent(StudentModel student){
            return repository.save(student);
    }






}















//controller(Routes) -> service (Business Logic) -> Repository(Database se Interaction)