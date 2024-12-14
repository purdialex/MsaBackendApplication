package com.example.MsaBackendApplication.service;

import com.example.MsaBackendApplication.model.Medicine;
import com.example.MsaBackendApplication.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository; // Inject the repository

    // Add a new medicine
    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine); // Persist to MongoDB
    }

    // Get all medicines
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll(); // Retrieve all documents
    }

    // Get medicine by ID
    public Optional<Medicine> getMedicineById(int id) {
        return medicineRepository.findById(id); // Find by ID in MongoDB
    }

    // Update a medicine
    public Medicine updateMedicine(int id, Medicine updatedMedicine) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id); // Fetch from the database
        if (optionalMedicine.isPresent()) {
            Medicine existingMedicine = optionalMedicine.get();
            existingMedicine.setName(updatedMedicine.getName());
            existingMedicine.setAssignedTo(updatedMedicine.getAssignedTo());
            existingMedicine.setPrescriptionId(updatedMedicine.getPrescriptionId());
            existingMedicine.setFrequency(updatedMedicine.getFrequency());
            existingMedicine.setDosage(updatedMedicine.getDosage());
            existingMedicine.setTakenToday(updatedMedicine.isTakenToday());
            return medicineRepository.save(existingMedicine); // Save updated entity to MongoDB
        }
        return null; // Return null if the medicine doesn't exist
    }

    // Delete a medicine by ID
    public boolean deleteMedicine(int id) {
        if (medicineRepository.existsById(id)) { // Check if the ID exists in MongoDB
            medicineRepository.deleteById(id); // Delete the document
            return true;
        }
        return false; // Return false if the medicine doesn't exist
    }
}