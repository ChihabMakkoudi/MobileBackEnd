package com.authedency.backendserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authedency.backendserver.models.Absence;
import com.authedency.backendserver.models.Session;
import com.authedency.backendserver.models.Student;
import com.authedency.backendserver.models.Subject;
import com.authedency.backendserver.models.Teacher;
import com.authedency.backendserver.services.SessionService;
import com.authedency.backendserver.services.StudentService;
import com.authedency.backendserver.services.SubjectService;
import com.authedency.backendserver.services.TeacherService;

@RestController
@RequestMapping("/api")
public class AttendanceController {
    
    @Autowired
    TeacherService teacherService;

    @Autowired
    SubjectService subjectService;
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    SessionService sessionService;

    @PostMapping("/login")
    public ResponseEntity<Teacher> login(@RequestParam String username, @RequestParam String password) {
        Teacher teacher = teacherService.getAuthenticated(username, password);
        return ResponseEntity.ok(teacher);
    }
    
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubjects(@RequestParam String teacher_id) {
        List<Subject> subjects = subjectService.getTeacherSubjects(teacher_id);
        return ResponseEntity.ok(subjects);
    }
    
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(@RequestParam String classes_id) {
        List<Student> students = studentService.getStudentOfClasse(classes_id);
        return ResponseEntity.ok(students);
    }
    
    @PostMapping("/startSession")
    public ResponseEntity<Session> startSession(@RequestParam String subject_id, @RequestParam String qrCode) {
        Session session = sessionService.newSession(subject_id, qrCode);
        return ResponseEntity.ok(session);
    }
    
    @PostMapping("/stopSession")
    public ResponseEntity<String> stoptSession(@RequestParam String session_id) {
        sessionService.stopSession(session_id);
        return ResponseEntity.ok("session stoped");
    }
    
    @GetMapping("/studentAttendance")
    public ResponseEntity<List<Absence>> getStudentAttendance(@RequestParam String student_id) {
        List<Absence> students = studentService.getStudentAbsences(student_id);
        return ResponseEntity.ok(students);
    }
}
