package com.example.backendlibrary.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BorrowedBooksRepository extends MongoRepository<BorrowedBooksRepository, String> {

}
