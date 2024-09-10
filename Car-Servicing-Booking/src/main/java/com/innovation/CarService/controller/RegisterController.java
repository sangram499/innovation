package com.innovation.CarService.controller;

import com.innovation.CarService.model.Register;
import com.innovation.CarService.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "http://localhost:4200") // Adjust if needed
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping
    public ResponseEntity<Register> registerUser(@RequestBody Register register) {
        Register registeredUser = registerService.registerUser(register);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping
    public List<Register> getAllRegistrations() {
        return registerService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Register> getRegistrationById(@PathVariable Long id) {
        Register register = registerService.getRegistrationById(id);
        return ResponseEntity.ok(register);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistrationById(@PathVariable Long id) {
        registerService.deleteRegistrationById(id);
        return ResponseEntity.noContent().build();
    }
}
