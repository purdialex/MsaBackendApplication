package com.example.MsaBackendApplication.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")  // Add the @Document annotation to map to the 'users' collection
public class Patient extends User {
    private String age;
    private String healthConditions;
}
