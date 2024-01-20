package com.example.backendlibrary.services;

import com.example.backendlibrary.models.Books;
import com.example.backendlibrary.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    BooksRepository bookRepo;

    // Add a book to db.
    public Books addBook(Books book) {
        return bookRepo.save(book);
    }

    // List all books from db.
    public List<Books> listBooks() {
        return bookRepo.findAll();
    }

    // List one book by ID
    public Books listOneBook(String id) {
        return bookRepo.findById(id).get();
    }

    // Delete a book by ID
    public void deleteBook(String id) {
        bookRepo.deleteById(id);
    }
}
