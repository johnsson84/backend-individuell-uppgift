package com.example.backendlibrary.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {

    @Id
    private String id;
    private String username;
    private String name;
    private String email;

    public Users() {

    }
}
