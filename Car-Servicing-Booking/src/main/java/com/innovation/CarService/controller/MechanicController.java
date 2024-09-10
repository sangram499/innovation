package com.innovation.CarService.controller;

import com.innovation.CarService.model.Mechanic;
import com.innovation.CarService.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mechanics")
public class MechanicController {

    @Autowired
    private MechanicService mechanicService;

    @PostMapping
    public ResponseEntity<Mechanic> createMechanic(@RequestBody Mechanic mechanic) {
        try {
            Mechanic savedMechanic = mechanicService.createMechanic(mechanic);
            return new ResponseEntity<>(savedMechanic, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Mechanic>> getAllMechanics() {
        try {
            List<Mechanic> mechanics = mechanicService.getAllMechanics();
            if (mechanics.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(mechanics, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mechanic> getMechanicById(@PathVariable("id") Long id) {
        Mechanic mechanic = mechanicService.getMechanicById(id);
        if (mechanic != null) {
            return new ResponseEntity<>(mechanic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mechanic> updateMechanic(@PathVariable("id") Long id, @RequestBody Mechanic mechanic) {
        // Ensure the mechanic has the correct ID
        mechanic.setId(id);
        try {
            Mechanic updatedMechanic = mechanicService.updateMechanic(mechanic);
            if (updatedMechanic != null) {
                return new ResponseEntity<>(updatedMechanic, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMechanic(@PathVariable("id") Long id) {
        try {
            mechanicService.deleteMechanic(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
