package com.example.MsaBackendApplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    private int id;
    private String name;
    private String assignedTo; // Represents the ID of the user this medicine is assigned to
    private int prescriptionId; // ID of the linked prescription
    private int frequency; // How many times per day
    private int dosage; // Dosage in standard units (e.g., mg, ml)
    private boolean takenToday; // Check whether it's taken today
}