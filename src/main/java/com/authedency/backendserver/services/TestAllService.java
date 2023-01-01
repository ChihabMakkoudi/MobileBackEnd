package com.authedency.backendserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authedency.backendserver.models.Classes;
import com.authedency.backendserver.models.Student;
import com.authedency.backendserver.models.Subject;
import com.authedency.backendserver.models.Teacher;
import com.authedency.backendserver.repositories.AbsenceRepository;
import com.authedency.backendserver.repositories.ClassesRepository;
import com.authedency.backendserver.repositories.SessionRepository;
import com.authedency.backendserver.repositories.StudentRepository;
import com.authedency.backendserver.repositories.SubjectRepository;
import com.authedency.backendserver.repositories.TeacherRepository;

@Service
public class TestAllService {
    
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private AbsenceRepository absenceRepository;


    public void test1(){

        Teacher t1 = new Teacher("t1", "t1", "t1", "t1");
        Teacher t2 = new Teacher("t2", "t2", "t2", "t2");

        Classes iql = new Classes("iql");
        Classes si = new Classes("si");

        Subject ngn = new Subject("ngn", t1, iql);
        Subject bi = new Subject("bi", t2, si);

        Student s1 = new Student("s1", "s1", "s1", "s1", iql);
        Student s2 = new Student("s2", "s2", "s2", "s2", iql);
        
        Student s3 = new Student("s3", "s3", "s3", "s3", si);
        Student s4 = new Student("s4", "s4", "s4", "s4", si);

        teacherRepository.save(t1);
        teacherRepository.save(t2);
        System.out.println("teacher saved");
        
        classesRepository.save(iql);
        classesRepository.save(si);
        System.out.println("classes saved");
        
        subjectRepository.save(ngn);
        subjectRepository.save(bi);
        System.out.println("subject saved");
        
        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
        studentRepository.save(s4);
        System.out.println("student saved");

        System.out.println("success");
    }

    public void test2(){
        Optional<Classes> op = classesRepository.findByName("iql");
        if(op.isPresent()){
            Classes iql = op.get();
            List<Student> students = studentRepository.findByClassesId(iql.getId());
            System.out.println(students);
        }else{
            System.out.println("no iqls");
        }
    }
    public void test3(){
        Optional<Teacher> t = teacherRepository.findByUserNameAndPassWord("t1", "t1");
        if(t.isPresent()){
            System.out.println(t.get());
        }else{
            System.out.println("no teach");
        }
    }
}
