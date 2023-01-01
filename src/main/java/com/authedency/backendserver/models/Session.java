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
@Document(collection = "sessions")
public class Session {
    
    @Id
    private String id;
    private String qrCode;
    private Date date;

    @DBRef
    private Subject subject;

    public Session(Subject subject, String qrCode) {
        this.subject = subject;
        this.qrCode = qrCode;
        this.date = new Date();
    }

}

