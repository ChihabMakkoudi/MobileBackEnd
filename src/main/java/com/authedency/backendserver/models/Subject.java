package com.authedency.backendserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "subjects")
public class Subject {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    @DBRef
    private Teacher teacher;
    
    @DBRef
    private Classes classes;

    public Subject(String name, Teacher teacher, Classes classes) {
        this.name = name;
        this.teacher = teacher;
        this.classes = classes;
    }

}

