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

    // POST Add a new book
    @PostMapping()
    public String addBook(@RequestBody Books book) {
        bookService.addBook(book);
        return "Book \"" + book.getTitle() + "\" added!";
    }

    // GET List all books
    @GetMapping()
    public List<Books> listBooks() {
        return bookService.listBooks();
    }

    // GET List one book by ID
    @GetMapping("/find/{id}")
    public Books listOneBook(@PathVariable String id) {
        return bookService.listOneBook(id);
    }
}
