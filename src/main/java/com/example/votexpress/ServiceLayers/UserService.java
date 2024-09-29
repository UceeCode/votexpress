package com.example.votexpress.ServiceLayers;

import com.example.votexpress.Repositories.UserRepositories;
import com.example.votexpress.Models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepositories userRepositories;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepositories userRepositories, PasswordEncoder passwordEncoder) {
        this.userRepositories = userRepositories;
        this.passwordEncoder = passwordEncoder;
    }

    //Register a user
    public User registerUser(User user) {
        if (userRepositories.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepositories.save(user);
    }

    //Find a user by email
    public Optional<User> findByUserByEmail(String email) {
        return userRepositories.findByEmail(email);
    }

    //Find a user by id
    public  User getUserById(long id){
        return userRepositories.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
