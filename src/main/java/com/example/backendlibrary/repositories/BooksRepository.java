package com.example.backendlibrary.repositories;

import com.example.backendlibrary.models.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepository extends MongoRepository<Books, String> {

}
