package com.example.votexpress.Repositories;

import com.example.votexpress.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    //Query to find all candidates by election
    List<Candidate> findByElectionId(Long electionId);
}
