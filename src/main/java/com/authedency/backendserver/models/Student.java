package com.authedency.backendserver.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "students")
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;

    @DBRef
    private Classes classes;

    public Student(String firstName, String lastName, String userName, String passWord, Classes classes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.classes = classes;
    }

}
