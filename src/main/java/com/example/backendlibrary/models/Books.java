package com.example.backendlibrary.models;

import org.springframework.data.annotation.Id;

public class Books {

    @Id
    private String id;
    private String title;
    private String description;
    private String[] author_name;

    public Books() {

    }


}
