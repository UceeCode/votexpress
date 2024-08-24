package com.example.votexpress;

import jakarta.persistence.*;

@Entity
@Table(name = "CANDIDATE")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String party;


}
