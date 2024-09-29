package com.example.votexpress.Controllers;

import com.example.votexpress.Models.Election;
import com.example.votexpress.ServiceLayers.ElectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/electionsapi")
public class ElectionController {
    private final ElectionService electionService;

    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    // Create a new election
    @PostMapping(value = "/createelectionapi")
    public ResponseEntity<String> createElection(@RequestBody Election election) {
        Election createdElection = electionService.CreateElection(election);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdElection.getName());
    }
}
