package com.authedency.backendserver.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.authedency.backendserver.models.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
    
    List<Student> findByClassesId(String id);

}
