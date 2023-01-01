package com.authedency.backendserver.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.authedency.backendserver.models.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher , String>{

    Optional<Teacher> findByUserNameAndPassWord(String userName, String passWord);
    
}