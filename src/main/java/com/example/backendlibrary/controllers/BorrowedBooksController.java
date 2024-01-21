package com.example.backendlibrary.controllers;

import com.example.backendlibrary.models.BorrowedBooks;
import com.example.backendlibrary.services.BorrowedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class BorrowedBooksController {

    @Autowired
    BorrowedBooksService borrowService;

    // GET List all borrowed books
    @GetMapping()
    public List<BorrowedBooks> listBorrowedBooks() {
        return borrowService.listBorrowedBooks();
    }

    // POST Borrow a book
    @PostMapping()
    public String borrowBook(@RequestBody BorrowedBooks borrow) {
        return borrowService.borrowBook(borrow);
    }
}
