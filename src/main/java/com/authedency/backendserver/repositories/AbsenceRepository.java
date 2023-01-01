package com.authedency.backendserver.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.authedency.backendserver.models.Absence;

public interface AbsenceRepository extends MongoRepository<Absence, String> {

    List<Absence> findByStudentId(String id);
    List<Absence> findBySessionId(String id);

}
