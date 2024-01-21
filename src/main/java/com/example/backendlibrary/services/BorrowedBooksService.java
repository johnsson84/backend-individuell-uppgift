package com.example.backendlibrary.services;

import com.example.backendlibrary.models.BorrowedBooks;
import com.example.backendlibrary.repositories.BorrowedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBooksService {

    @Autowired
    BorrowedBooksRepository borrowRepo;

    // List all borrowed books
    public List<BorrowedBooks> listBorrowedBooks() {
        return borrowRepo.findAll();
    }

    // Borrow a book
    public String borrowBook(BorrowedBooks borrow) {

        borrowRepo.save(borrow);
        return "\"" + borrow.getBook_name() + "\" borrowed!";
    }

    // List a specific loan
    public BorrowedBooks listOneLoan(String id) {
        return borrowRepo.findById(id).get();
    }
}
