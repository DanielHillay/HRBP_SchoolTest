package com.assessment.testschool.controller;


import com.assessment.testschool.entity.StandardResponse;
import com.assessment.testschool.entity.User;
import com.assessment.testschool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<StandardResponse> createNewStudent(@RequestBody User student){
        return userService.createNewStudent(student);
    }

    @GetMapping("/getstudents")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<StandardResponse> getAllStudents(){
        return userService.getAllStudents();
    }
}
