package com.example.backendlibrary.controllers;

import com.example.backendlibrary.models.Users;
import com.example.backendlibrary.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UsersService userService;

    // POST Add a new user
    @PostMapping()
    public String addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    // GET List all users
    @GetMapping()
    public List<Users> listUsers() {
        return userService.listUsers();
    }

    // GET Find a user
    @GetMapping("/{id}")
    public Users listOneUser(@PathVariable String id) {
        return userService.listOneUser(id);
    }

    // DELETE Delete a user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

    // PUT Update a user
    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }
}
