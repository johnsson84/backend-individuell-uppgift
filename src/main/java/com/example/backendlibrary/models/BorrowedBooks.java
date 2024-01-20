package com.example.backendlibrary.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "borrowedBooks")
public class BorrowedBooks {

    @Id
    private String id;
    private String book_id;
    private String user_id;
    @CreatedDate
    private Date borrowed_date;
}
