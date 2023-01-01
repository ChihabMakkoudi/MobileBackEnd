package com.authedency.backendserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "teachers")
public class Teacher {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    
    public void update(Teacher newtTeacher) {
        this.firstName = newtTeacher.getFirstName();
        this.lastName = newtTeacher.getLastName();
        this.userName = newtTeacher.getUserName();
        this.passWord = newtTeacher.getUserName();
    }

    public Teacher(String firstName, String lastName, String userName, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
    }

}
