package com.example.backendlibrary.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Books {

    @Id
    private String id;
    private String title;
    private String description;
    private String[] author_name;

    public Books() {

    }


}
