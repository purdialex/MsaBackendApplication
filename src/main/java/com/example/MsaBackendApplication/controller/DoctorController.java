package com.example.MsaBackendApplication.controller;

import com.example.MsaBackendApplication.model.User;
import com.example.MsaBackendApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private UserService userService;  // Using UserService as Doctor is a type of User

    // Get all doctors
    @GetMapping
    public ResponseEntity<List<User>> getAllDoctors() {
        List<User> doctors = userService.getAllUsers()
                .stream()
                .filter(user -> !user.isPatient()) // Filter for users who are doctors
                .toList();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getDoctorById(@PathVariable String id) {
        Optional<User> doctor = userService.getUserById(id);
        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new doctor
    @PostMapping
    public ResponseEntity<User> createDoctor(@RequestBody User doctor) {
        User createdDoctor = userService.createUser(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor);
    }

    // Update doctor by ID
    @PutMapping("/{id}")
    public ResponseEntity<User> updateDoctor(@PathVariable String id, @RequestBody User doctor) {
        User updatedDoctor = userService.updateUser(id, doctor);
        return updatedDoctor != null ? ResponseEntity.ok(updatedDoctor) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable String id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
