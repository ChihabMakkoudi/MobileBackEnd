package com.authedency.backendserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authedency.backendserver.models.Absence;
import com.authedency.backendserver.models.Session;
import com.authedency.backendserver.models.Student;
import com.authedency.backendserver.models.Subject;
import com.authedency.backendserver.repositories.AbsenceRepository;
import com.authedency.backendserver.repositories.SessionRepository;
import com.authedency.backendserver.repositories.StudentRepository;
import com.authedency.backendserver.repositories.SubjectRepository;

@Service
public class SessionService {
    
    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    SubjectRepository subjectRepository;
    
    @Autowired
    AbsenceRepository absenceRepository;

    @Autowired
    StudentRepository studentRepository;

    public Session newSession(String Subject_id, String qrCode){
        Optional<Subject> opt = subjectRepository.findById(Subject_id);
        if(opt.isPresent()){
            Subject subject = opt.get();

            Session nSession=new Session(subject, qrCode);
            sessionRepository.save(nSession);

            List<Student> students = studentRepository.findByClassesId(subject.getClasses().getId());
            for (Student student : students) {
                Absence ab = new Absence(student, nSession);
                absenceRepository.save(ab);
            }
            return nSession;
        }
        return null;
    }

    public void stopSession(String session_id) {
        Optional<Session> opt = sessionRepository.findById(session_id);
        if(opt.isPresent()){
            Session session = opt.get();
            session.setQrCode("");
            sessionRepository.save(session);
        }
    }

}
