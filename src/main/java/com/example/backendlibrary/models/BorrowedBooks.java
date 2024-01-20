package com.example.backendlibrary.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class BorrowedBooks {

    @Id
    private String id;
    private String book_id;
    private String user_id;
    @CreatedDate
    private Date borrowed_date;
}
