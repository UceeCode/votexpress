package com.example.votexpress.ServiceLayers;

import com.example.votexpress.Repositories.UserRepositories;
import com.example.votexpress.Models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    // Register a user
    public User registerUser(User user) {
        // Check if the email is already in use
        if (userRepositories.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        // Save user without encoding the password
        return userRepositories.save(user);
    }

    // Find a user by email
    public Optional<User> findByUserByEmail(String email) {
        return userRepositories.findByEmail(email);
    }

    // Find a user by ID
    public User getUserById(long id) {
        return userRepositories.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
