package com.example.votexpress.Repositories;

import com.example.votexpress.Models.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {

    //Query to find elections by name
    Election findByname(String name);
}
