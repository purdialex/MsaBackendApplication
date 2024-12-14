package com.example.MsaBackendApplication.controller;
import com.example.MsaBackendApplication.model.Medicine;
import com.example.MsaBackendApplication.service.MedicineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    // Add a new medicine (POST)
    @PostMapping
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
        return ResponseEntity.ok(medicineService.addMedicine(medicine));
    }

    // Get all medicines (GET)
    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        return ResponseEntity.ok(medicineService.getAllMedicines());
    }

    // Get a single medicine by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable int id) {
        Optional<Medicine> medicine = medicineService.getMedicineById(id);
        return medicine.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update a medicine (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable int id, @RequestBody Medicine medicine) {
        Medicine updatedMedicine = medicineService.updateMedicine(id, medicine);
        if (updatedMedicine != null) {
            return ResponseEntity.ok(updatedMedicine);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a medicine (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable int id) {
        if (medicineService.deleteMedicine(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
