package com.assessment.testschool.service;

import com.assessment.testschool.entity.StandardResponse;
import com.assessment.testschool.repository.RoleRepository;
import com.assessment.testschool.entity.Role;
import com.assessment.testschool.entity.User;
import com.assessment.testschool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepo.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepo.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);
    }

    public ResponseEntity<StandardResponse> registerNewUser(User user) {
        try {
            Role role = roleRepo.findByRoleName("User").get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);

            boolean loggedUser = userRepository.findByUserName(user.getUserName()).isPresent();
            if(!loggedUser) {
                user.setRole(roles);
                user.setTag("User");
                user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

                User savedUser = userRepository.save(user);
                return StandardResponse.sendHttpResponse(true, "Operation successful!", savedUser, "200");
            }else{
                return StandardResponse.sendHttpResponse(false, "User already exists");
            }
        } catch (Exception e) {

            return StandardResponse.sendHttpResponse(false, "Could not save user");
        }
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public ResponseEntity<StandardResponse> registerAdminUser(User user) {
        try {
            Role role = roleRepo.findByRoleName("Admin").get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);

            boolean loggedUser = userRepository.findByUserName(user.getUserName()).isPresent();
            if(!loggedUser) {
                user.setRole(roles);
                user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

                User savedUser = userRepository.save(user);
                return StandardResponse.sendHttpResponse(true, "Operation successful!", savedUser, "200");
            }else{
                return StandardResponse.sendHttpResponse(false, "Admin already exists");
            }
        } catch (Exception e) {

            return StandardResponse.sendHttpResponse(false, "Could not save Admin");
        }
    }

    public ResponseEntity<StandardResponse> registerTeacher(User teacher) {
        try {
            Role role = roleRepo.findByRoleName("Teacher").get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);

            boolean loggedUser = userRepository.findByUserName(teacher.getUserName()).isPresent();
            if (!loggedUser) {
                teacher.setRole(roles);
                teacher.setTag("Teacher");
                teacher.setUserPassword(passwordEncoder.encode(teacher.getUserPassword()));

                User savedUser = userRepository.save(teacher);
                return StandardResponse.sendHttpResponse(true, "Operation successful!", savedUser, "200");
            } else {
                return StandardResponse.sendHttpResponse(false, "User already exists");
            }
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not save user");
        }
    }

    public ResponseEntity<StandardResponse> createNewStudent(User student) {

        try {
            Role role = roleRepo.findByRoleName("Student").get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);

            boolean loggedUser = userRepository.findByUserName(student.getUserName()).isPresent();
            if(!loggedUser) {
                student.setRole(roles);
                student.setTag("Student");
                student.setUserPassword(passwordEncoder.encode(student.getUserPassword()));

                User savedUser = userRepository.save(student);
                return StandardResponse.sendHttpResponse(true, "Operation successful!", savedUser, "200");
            }else{
                return StandardResponse.sendHttpResponse(false, "User already exists");
            }
        } catch (Exception e) {

            return StandardResponse.sendHttpResponse(false, "Could not save user");
        }
    }

    public ResponseEntity<StandardResponse> getAllStudents() {
        try {
            List<User> studentList = userRepository.findByTag("Student");
            return StandardResponse.sendHttpResponse(true, "Operation successful!", studentList, "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(true, "Could not fetch students");
        }
    }
}
