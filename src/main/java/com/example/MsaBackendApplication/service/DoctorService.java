package com.example.MsaBackendApplication.service;

import com.example.MsaBackendApplication.model.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends UserService {

    // Add additional methods for Doctor-specific operations if needed
    public Doctor updateDoctor(String id, Doctor doctorDetails) {
        return (Doctor) updateUser(id, doctorDetails);  // reuse the method from UserService
    }
}
