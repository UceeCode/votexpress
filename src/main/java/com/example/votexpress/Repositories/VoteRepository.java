package com.example.votexpress.Repositories;

import com.example.votexpress.Models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    // Custom query to find votes by user ID
    List<Vote> findByUser_Id(Long id);

    // Custom query to find votes by election ID
    List<Vote> findByElection_Id(Long id);
}
