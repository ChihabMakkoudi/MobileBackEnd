package com.authedency.backendserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authedency.backendserver.models.Subject;
import com.authedency.backendserver.repositories.SubjectRepository;

@Service
public class SubjectService {
    
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getTeacherSubjects(String teacherId){
        return subjectRepository.findByTeacherId(teacherId);
    }
    
    public Subject findSubject(String name){
        Optional<Subject> opt = subjectRepository.findByName(name);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }
}
