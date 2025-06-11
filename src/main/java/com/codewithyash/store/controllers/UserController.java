package com.codewithyash.store.controllers;

import com.codewithyash.store.repositories.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

import com.codewithyash.store.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping    
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
        // This method should return a list of users
        // For now, returning an empty list
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        var user= userRepository.findById(id).orElse(null);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}
