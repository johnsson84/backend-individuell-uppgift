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
    public String addBook(Books book) {
        bookRepo.save(book);
        return "Book \"" + book.getTitle() + "\" added!";
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
    public String deleteBook(String id) {
        bookRepo.deleteById(id);
        return "Book deleted!";
    }

    // Update a book by ID
    public String updateBook(String id, Books book) {
        // Temp save all books
        List<Books> allBooks = bookRepo.findAll();
        // When updating, check if id in path and body is same and exists in books
        for (Books books : allBooks) {
            if (id.equals(books.getId()) && book.getId().equals(id)) {
                bookRepo.save(book);
                return "Book updated!";
            }
        }
        return "Book not found...";

    }
}
