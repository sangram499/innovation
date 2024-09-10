package com.innovation.CarService.controller;

import com.innovation.CarService.model.Admin;
import com.innovation.CarService.model.User;
import com.innovation.CarService.service.AdminService;
import com.innovation.CarService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password, @RequestParam String type) {
        if ("admin".equalsIgnoreCase(type)) {
            Optional<Admin> adminOptional = adminService.findByUsername(username);
            if (adminOptional.isPresent()) {
                Admin admin = adminOptional.get();
                if (admin.getPassword().equals(password)) {
                    return ResponseEntity.ok("Admin login successful");
                }
            }
        } else if ("user".equalsIgnoreCase(type)) {
            Optional<User> userOptional = userService.findByUsername(username);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (user.getPassword().equals(password)) {
                    return ResponseEntity.ok("User login successful");
                }
            }
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    // User Registration Endpoint
    @PostMapping("/register/user")
    public ResponseEntity<String> registerUser(@RequestBody User newUser) {
        if (userService.findByUsername(newUser.getUsername()).isEmpty()) {
            userService.saveUser(newUser);
            return ResponseEntity.ok("User registered successfully");
        }
        return ResponseEntity.status(400).body("Username already exists");
    }

    // Admin Registration Endpoint
    @PostMapping("/register/admin")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin newAdmin) {
        if (adminService.findByUsername(newAdmin.getUsername()).isEmpty()) {
            adminService.saveAdmin(newAdmin);
            return ResponseEntity.ok("Admin registered successfully");
        }
        return ResponseEntity.status(400).body("Username already exists");
    }
}
