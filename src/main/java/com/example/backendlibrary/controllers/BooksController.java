package com.example.backendlibrary.controllers;

import com.example.backendlibrary.models.Books;
import com.example.backendlibrary.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/book")
public class BooksController {

    @Autowired
    BooksService bookService;

    @PostMapping()
    public Books addBook(@RequestBody Books book) {
        return bookService.addBook(book);
    }

    @GetMapping()
    public List<Books> listBooks() {
        return bookService.listBooks();
    }
}
