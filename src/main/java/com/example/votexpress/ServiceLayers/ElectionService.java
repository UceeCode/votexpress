package com.example.votexpress.ServiceLayers;

import com.example.votexpress.Models.Election;
import com.example.votexpress.Repositories.ElectionRepository;
import org.springframework.stereotype.Service;

@Service
public class ElectionService {
    private final ElectionRepository electionRepository;
    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    //Create an election
    public Election CreateElection(Election election) {
        return electionRepository.save(election);
    }

    //Find an Election by name
    public Election getElectionName(String name){
        return electionRepository.findByname(name);
    }

    //find an election by id
    public Election getElectionById(long id){
        return electionRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Election not found"));
    }

    public Election updateElection(long id, Election electionDetails) {
        Election existingElection = getElectionById(id);
        existingElection.setName(electionDetails.getName());
        existingElection.setStartdate(electionDetails.getStartdate());
        existingElection.setEnddate(electionDetails.getEnddate());
        return electionRepository.save(existingElection);
    }

    public void deleteElection(long id) {
        electionRepository.deleteById(id);
    }
}
