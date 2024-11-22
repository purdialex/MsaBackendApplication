package com.example.MsaBackendApplication.service;

import com.example.MsaBackendApplication.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends UserService {

    // Add additional methods for Patient-specific operations if needed
    public Patient updatePatient(String id, Patient patientDetails) {
        return (Patient) updateUser(id, patientDetails);  // reuse the method from UserService
    }
}
