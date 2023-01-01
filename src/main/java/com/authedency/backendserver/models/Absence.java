package com.authedency.backendserver.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "absences")
public class Absence {
    @Id
    private String id;
    
    @DBRef
    private Student student;

    @DBRef
    private Session session;
    
    private boolean isAbsent;
    private Date date;
    
    public Absence(Student student, Session session) {
        this.student = student;
        this.session = session;
        this.isAbsent = true;
        this.date = new Date();
    }

    public Absence(Student student, Session session, boolean isAbsent) {
        this.student = student;
        this.session = session;
        this.isAbsent = isAbsent;
        this.date = new Date();
    }

}
