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
    private String book_name;
    private String borrowers_id;
    private String borrowers_name;
    @CreatedDate
    private Date borrowed_date;
    private String return_date;

    public BorrowedBooks() {
    }

    public String getId() {
        return id;
    }

    public String getBook_id() {
        return book_id;
    }

    public String getUser_id() {
        return borrowers_id;
    }

    public Date getBorrowed_date() {
        return borrowed_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getUser_name() {
        return borrowers_name;
    }
}
