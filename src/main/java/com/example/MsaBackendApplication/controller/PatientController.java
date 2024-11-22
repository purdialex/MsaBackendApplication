package com.example.MsaBackendApplication.controller;

import com.example.MsaBackendApplication.model.Patient;
import com.example.MsaBackendApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private UserService userService; // Using UserService as Patient is a subclass of User

    // Get all patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = userService.getAllUsers().stream()
                .filter(user -> user instanceof Patient)  // Filter only Patient objects
                .map(user -> (Patient) user)  // Cast to Patient
                .collect(Collectors.toList());
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        Optional<Patient> patient = userService.getUserById(id)
                .filter(user -> user instanceof Patient)  // Ensure it's a Patient
                .map(user -> (Patient) user);  // Cast to Patient
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new patient
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = (Patient) userService.createUser(patient); // Create user (Patient is a subclass of User)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    // Update patient by ID
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient patient) {
        Patient updatedPatient = (Patient) userService.updateUser(id, patient); // Update and cast to Patient
        return updatedPatient != null ? ResponseEntity.ok(updatedPatient) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete patient by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id) {
        boolean isDeleted = userService.deleteUser(id); // Delete user (Patient is a subclass of User)
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
