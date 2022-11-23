package com.assessment.testschool.controller;

import com.assessment.testschool.entity.StandardResponse;
import com.assessment.testschool.entity.User;
import com.assessment.testschool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public ResponseEntity<StandardResponse> registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @PostMapping("/registeradminuser")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<StandardResponse> registerAdminUser(@RequestBody User user) {
        return userService.registerAdminUser(user);
    }

    @GetMapping({"/registerTeacher"})
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<StandardResponse> registerTeacher(@RequestBody User user){
        return userService.registerTeacher(user);
    }
}
