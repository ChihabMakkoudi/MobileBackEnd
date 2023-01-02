package com.authedency.backendserver.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.authedency.backendserver.models.Session;

public interface SessionRepository extends MongoRepository<Session, String> {
    
    List<Session> findBySubjectId(String id);

}
