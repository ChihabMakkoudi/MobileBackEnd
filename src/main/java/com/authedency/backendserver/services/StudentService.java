package com.authedency.backendserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authedency.backendserver.models.Absence;
import com.authedency.backendserver.models.Session;
import com.authedency.backendserver.models.Student;
import com.authedency.backendserver.repositories.AbsenceRepository;
import com.authedency.backendserver.repositories.SessionRepository;
import com.authedency.backendserver.repositories.StudentRepository;
import com.authedency.backendserver.repositories.SubjectRepository;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    AbsenceRepository absenceRepository;

    @Autowired
    SessionRepository sessionRepository;

    public List<Student> getStudentOfClasse(String classes_id){
        return studentRepository.findByClassesId(classes_id);
    }

    public List<Absence> getStudentAbsences(String student_id, String subject_id){
        List<Session> sessions = sessionRepository.findBySubjectId(subject_id);
        List<Absence> absences=new ArrayList<Absence>();
        for (Session s : sessions) {
            List<Absence> a = absenceRepository.findByStudentIdAndSessionId(student_id, s.getId());
            absences.addAll(a);
        }
        return absences;
    }

    public List<Student> getAbsentStudent(String session_id){
        List<Absence> absences = absenceRepository.findBySessionId(session_id);
        List<Student> absentStudents = new ArrayList<>();
        
        for (Absence absence : absences) {
            absentStudents.add(absence.getStudent());
        }
        
        return absentStudents;
    }
}
