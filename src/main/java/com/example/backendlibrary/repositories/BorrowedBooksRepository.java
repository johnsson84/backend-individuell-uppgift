package com.example.backendlibrary.repositories;

import com.example.backendlibrary.models.BorrowedBooks;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BorrowedBooksRepository extends MongoRepository<BorrowedBooks, String> {

}
