package com.example.MsaBackendApplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.MsaBackendApplication.model.Medicine;

public interface MedicineRepository extends MongoRepository<Medicine, Integer> {
    // Additional query methods if needed
}