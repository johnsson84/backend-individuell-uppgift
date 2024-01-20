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


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String[] getAuthor_name() {
        return author_name;
    }
}
