package com.example.votexpress;

import jakarta.persistence.*;

@Entity
@Table(name = "VOTE")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "candidate", nullable = false)
    private String candidate;

    @Column(name = "election_id", nullable = false)
    private Long electionId;

    public Vote() {}

    public Vote(User user, String candidate, Long electionId) {
        this.user = user;
        this.candidate = candidate;
        this.electionId = electionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public Long getElectionId() {
        return electionId;
    }

    public void setElectionId(Long electionId) {
        this.electionId = electionId;
    }
}
