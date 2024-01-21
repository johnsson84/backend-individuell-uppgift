package com.example.backendlibrary.services;

import com.example.backendlibrary.models.Books;
import com.example.backendlibrary.models.BorrowedBooks;
import com.example.backendlibrary.models.Users;
import com.example.backendlibrary.repositories.BooksRepository;
import com.example.backendlibrary.repositories.BorrowedBooksRepository;
import com.example.backendlibrary.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBooksService {

    @Autowired
    BorrowedBooksRepository borrowRepo;
    @Autowired
    BooksRepository bookRepo;
    @Autowired
    UsersRepository userRepo;


    // List all borrowed books
    public List<BorrowedBooks> listBorrowedBooks() {
        return borrowRepo.findAll();
    }

    // Borrow a book
    public String borrowBook(BorrowedBooks borrow) {
        List<Books> allBooks = bookRepo.findAll();
        List<Users> allUsers = userRepo.findAll();
        for (Books book : allBooks) {
            if (borrow.getBook_id().equals(book.getId())) {
                borrow.setBook_name(book.getTitle());
            }
        }
        for (Users user : allUsers) {
            if (borrow.getBorrowers_id().equals(user.getId())) {
                borrow.setBorrowers_name(user.getName());
            }
        }
        if (borrow.getBook_name().equals("") || borrow.getBorrowers_name().equals("")) {
            return "ERROR: User or book does not exist";
        }
        borrowRepo.save(borrow);
        return "Book \"" + borrow.getBook_name() + "\" borrowed by " + borrow.getBorrowers_name();
    }

    // List a specific loan
    public BorrowedBooks listOneLoan(String id) {
        return borrowRepo.findById(id).get();
    }
}
