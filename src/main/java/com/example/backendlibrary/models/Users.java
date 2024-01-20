package com.example.backendlibrary.models;

import org.springframework.data.annotation.Id;

public class Users {

    @Id
    private String id;
    private String username;
    private String name;
    private String email;

    public Users() {

    }
}
