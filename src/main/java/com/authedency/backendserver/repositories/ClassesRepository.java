package com.authedency.backendserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.authedency.backendserver.models.Classes;

import java.util.Optional;

public interface ClassesRepository extends MongoRepository<Classes, String> {
    
    Optional<Classes> findByName(String name);
    
}
