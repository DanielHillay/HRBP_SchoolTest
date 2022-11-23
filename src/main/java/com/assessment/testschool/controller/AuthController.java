package com.assessment.testschool.controller;

import com.assessment.testschool.entity.LoginRequest;
import com.assessment.testschool.entity.StandardResponse;
import com.assessment.testschool.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public ResponseEntity<StandardResponse> createJwtToken(@RequestBody LoginRequest login) throws Exception {
        return jwtService.createJwtToken(login);
    }
}
