package com.example.backendlibrary.services;

import com.example.backendlibrary.models.Users;
import com.example.backendlibrary.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository userRepo;

    // Add a new user
    public String addUser(Users user) {
        // Temp save all existing users.
        List<Users> allUsers = userRepo.findAll();
        // Check if username or email is already registered.
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getUsername().equals(user.getUsername()) ||
                allUsers.get(i).getEmail().equals(user.getEmail())) {
                return "Username or email already exists";
            }
        }
        userRepo.save(user);
        return "User \"" + user.getName() + "\" added!";
    }

    // List all users from db.
    public List<Users> listUsers() {
        return userRepo.findAll();
    }

    // List one user by ID
    public Users listOneUser(String id) {
        return userRepo.findById(id).get();
    }

    // Delete a user by ID
    public String deleteUser(String id) {
        userRepo.deleteById(id);
        return "User deleted!";
    }

    // Update a user by ID
    public String updateUser(String id, Users user) {
        // Temp save all existing users
        List<Users> allUsers = userRepo.findAll();
        // When updating, check if id in path and body is same and exists in users
        for (Users users : allUsers) {
            if (id.equals(users.getId()) && user.getId().equals(id)) {
                userRepo.save(user);
                return "User updated!";
            }
        }
        return "User not found...";

    }
}
