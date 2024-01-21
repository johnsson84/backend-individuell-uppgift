package com.example.backendlibrary.controllers;

import com.example.backendlibrary.models.Books;
import com.example.backendlibrary.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/books")
public class BooksController {

    @Autowired
    BooksService bookService;

    // POST Add a new book
    @PostMapping()
    public String addBook(@RequestBody Books book) {
        return bookService.addBook(book);
    }

    // GET List all books
    @GetMapping()
    public List<Books> listBooks() {
        return bookService.listBooks();
    }

    // GET List one book by ID
    @GetMapping("/{id}")
    public Books listOneBook(@PathVariable String id) {
        return bookService.listOneBook(id);
    }

    // DELETE Delete a book by ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        return bookService.deleteBook(id);
    }

    // PUT Update a book by ID
    @PutMapping("/{id}")
    public String updateBook(@PathVariable String id, @RequestBody Books book) {
        return bookService.updateBook(id, book);
    }
}
