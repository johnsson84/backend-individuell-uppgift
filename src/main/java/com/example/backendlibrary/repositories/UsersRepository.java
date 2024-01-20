package com.example.backendlibrary.repositories;

import com.example.backendlibrary.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {

}
