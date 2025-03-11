package com.graphql.graphql.controllers;

import com.graphql.graphql.model.User;
import com.graphql.graphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "User already exists!";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        user.setRoles(Collections.singletonList("USER")); // Default role
        userRepository.save(user);
        return "User registered successfully!";
    }
}
