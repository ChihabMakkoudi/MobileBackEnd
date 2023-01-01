package com.authedency.backendserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.authedency.backendserver.models.Session;

public interface SessionRepository extends MongoRepository<Session, String> {
}
