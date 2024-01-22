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
        // Find book name and add it the body "borrow"
        for (Books book : allBooks) {
            if (borrow.getBook_id().equals(book.getId())) {
                borrow.setBook_name(book.getTitle());
            }
        }
        // Find borrowing users name and add it the body "borrow"
        for (Users user : allUsers) {
            if (borrow.getBorrowers_id().equals(user.getId())) {
                borrow.setBorrowers_name(user.getName());
            }
        }
        // If no book name or users name was found, give error
        if (borrow.getBook_name().equals("") || borrow.getBorrowers_name().equals("")) {
            return "ERROR: User or book does not exist";
        }
        borrowRepo.save(borrow);
        return "Book \"" + borrow.getBook_name() + "\" borrowed by " + borrow.getBorrowers_name();
    }

    // List a specific loan
    public BorrowedBooks listOneLoan(String id) {
        List<BorrowedBooks> allLoans = borrowRepo.findAll();
        // Check if loan exists
        for (BorrowedBooks loan : allLoans) {
            if (id.equals(loan.getId())) {
                return borrowRepo.findById(id).get();
            }
        }
        // If loan does not exists, respond with an empty loan instead
        // of server 500 crash. This happends if you input a wrong id number.
        allLoans.clear();
        allLoans.add(new BorrowedBooks());
        return allLoans.get(0);
    }

    // Delete a loan
    public String deleteLoan(String id) {
        List<BorrowedBooks> allLoans = borrowRepo.findAll();
        for (BorrowedBooks loan : allLoans) {
            if (id.equals(loan.getId())) {
                borrowRepo.deleteById(id);
                return "Loan deleted successfully!";
            }
        }
        return "ERROR: Loan does not exist";
    }

    // Update a loan
    public String updateLoan(String id, BorrowedBooks loan) {
        // Temp save all existing loans
        List<BorrowedBooks> allLoans = borrowRepo.findAll();
        // When updating, check if ID in PATH and BODY is the same and exists in loans
        for (BorrowedBooks loans : allLoans) {
            if (id.equals(loans.getId()) && loan.getId().equals(id)) {
                borrowRepo.save(loan);
                return "Loan successfully updated!";
            }
        }
        return "ERROR: Loan does not exist!";
    }
}
