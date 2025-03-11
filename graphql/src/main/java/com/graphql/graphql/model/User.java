package com.graphql.graphql.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users") // MongoDB collection name
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private List<String> roles;

    public User(String id, String name, String email, String password, List<String> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

}
