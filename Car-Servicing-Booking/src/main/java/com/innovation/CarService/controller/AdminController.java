package com.innovation.CarService.controller;

import com.innovation.CarService.model.Admin;
import com.innovation.CarService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestParam String username, @RequestParam String password) {
        Optional<Admin> adminOptional = adminService.findByUsername(username);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            if (admin.getPassword().equals(password)) {
                return ResponseEntity.ok("Admin login successful");
            }
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin newAdmin) {
        if (adminService.findByUsername(newAdmin.getUsername()).isEmpty()) {
            adminService.saveAdmin(newAdmin);
            return ResponseEntity.ok("Admin registered successfully");
        }
        return ResponseEntity.status(400).body("Username already exists");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> adminOptional = adminService.findById(id);
        return adminOptional.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        if (adminService.findById(id).isPresent()) {
            adminService.deleteAdmin(id);
            return ResponseEntity.ok("Admin deleted successfully");
        }
        return ResponseEntity.status(404).body("Admin not found");
    }
}
