package com.authedency.backendserver.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.authedency.backendserver.models.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String> {

    Optional<Subject> findByName(String name);
    List<Subject> findByTeacherId(String id);

}
