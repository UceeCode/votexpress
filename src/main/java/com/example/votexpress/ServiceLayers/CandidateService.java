package com.example.votexpress.ServiceLayers;

import com.example.votexpress.Candidate;
import com.example.votexpress.Repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    //Retrieve all candidates for a given election
    public List<Candidate> getCanidatesByElection(long electionId) {
        return candidateRepository.findByElectionId(electionId);
    }

    //Create a new Candidate
    public Candidate createCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public Candidate getCandidateById(long id) {
        return candidateRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Could not find candidate with id: " + id));
    }
}
