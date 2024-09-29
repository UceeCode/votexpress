package com.example.votexpress.Repositories;

import com.example.votexpress.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {

    //Query to find user by email
    Optional<User> findByEmail(String username);
}
