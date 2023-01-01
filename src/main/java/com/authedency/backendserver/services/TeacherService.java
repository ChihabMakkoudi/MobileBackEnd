package com.authedency.backendserver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authedency.backendserver.models.Teacher;
import com.authedency.backendserver.repositories.TeacherRepository;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getById(String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        return null;
    }
    
    public Teacher getAuthenticated(String userName, String passWord) {
        Optional<Teacher> teacher = teacherRepository.findByUserNameAndPassWord(userName, passWord);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        return null;
    }
    
    public Teacher updatePasseWord(String userName, String oldPassWord, String newPassWord){
        Optional<Teacher> teacher = teacherRepository.findByUserNameAndPassWord(userName, oldPassWord);
        if (teacher.isPresent()) {
            Teacher newTeacher = teacher.get();
            newTeacher.setPassWord(newPassWord);
            return teacherRepository.save(newTeacher);
        }
        return null;
    }
}
