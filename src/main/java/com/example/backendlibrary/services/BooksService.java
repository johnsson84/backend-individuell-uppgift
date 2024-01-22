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
        // Temp save all books
        List<Books> allBooks = bookRepo.findAll();
        // Check if book title already exists
        for (Books books : allBooks) {
            if (book.getTitle().equals(books.getTitle())) {
                return "Book name already registered!";
            }
        }
        bookRepo.save(book);
        return "Book \"" + book.getTitle() + "\" added!";
    }

    // List all books from db.
    public List<Books> listBooks() {
        return bookRepo.findAll();
    }

    // List one book by ID
    public Books listOneBook(String id) {
        List<Books> allBooks = bookRepo.findAll();
        // Check if book exists
        for (Books book : allBooks) {
            if (id.equals(book.getId())) {
                return bookRepo.findById(id).get();
            }
        }
        // If book does not exists, respond with an empty book instead
        // of server 500 crash. This happends if you input a wrong id number.
        allBooks.clear();
        allBooks.add(new Books());
        return allBooks.get(0);
    }

    // Delete a book by ID
    public String deleteBook(String id) {
        List<Books> allBooks = bookRepo.findAll();
        // Check if book exist otherwise error.
        for (Books book : allBooks) {
            if (id.equals(book.getId())) {
                bookRepo.deleteById(id);
                return "Book deleted!";
            }
        }
        return "ERROR: Book does not exist!";
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
        return "ERROR: Book does not exist or ID mismatch!";

    }
}
