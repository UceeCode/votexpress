package com.example.votexpress.ServiceLayers;

import com.example.votexpress.Repositories.VoteRepository;
import com.example.votexpress.Models.Vote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    //Submit a vote
    public Vote SubmitVote(Vote vote) {
        return voteRepository.save(vote);
    }

    //find votes by user id
    public List<Vote> getVotesByUserId(long userId) {
        return voteRepository.findByUser_Id(userId);
    }

    //find votes by election id
    public List<Vote> getVotesByElectionId(long electionId) {
        return voteRepository.findByElection_Id(electionId);
    }
}
