package com.authedency.backendserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "classes")
public class Classes {
    
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    public Classes(String name) {
        this.name = name;
    }
}



