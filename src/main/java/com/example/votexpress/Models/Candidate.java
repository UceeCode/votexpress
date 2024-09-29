package com.example.votexpress.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "CANDIDATE")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "party", nullable = false)
    private String party;

    @ManyToOne
    @JoinColumn(name = "election_id", nullable = false)
    private Election election;

    public Candidate() {}

    public Candidate(String name, String party, Election election) {
        this.name = name;
        this.party = party;
        this.election = election;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }
}
