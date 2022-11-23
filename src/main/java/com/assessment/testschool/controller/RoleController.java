package com.assessment.testschool.controller;

import com.assessment.testschool.entity.Role;
import com.assessment.testschool.entity.StandardResponse;
import com.assessment.testschool.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<StandardResponse> createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }

    @GetMapping("/getallroles")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<StandardResponse> getAllRoles(){
        return roleService.getAllRoles();
    }
}
