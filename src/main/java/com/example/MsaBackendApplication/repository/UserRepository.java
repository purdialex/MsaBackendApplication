package com.example.MsaBackendApplication.repository;

import com.example.MsaBackendApplication.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Custom query methods (optional)
}
