package com.example.votexpress.Controllers;

import com.example.votexpress.Models.Election;
import com.example.votexpress.ServiceLayers.ElectionService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Get all election
    @GetMapping(path = "/getallelectionsapi")
    public ResponseEntity<List<Election>> getAllElections() {
        return ResponseEntity.ok(electionService.getAllElections());
    }

    // Get Election by Id
    @GetMapping(path = "{id}")
    public ResponseEntity<Election> getElectionById(@PathVariable Long id) {
        return ResponseEntity.ok(electionService.getElectionById(id));
    }

    // Get Election by name
    @GetMapping(path = "/name/{name}")
    public ResponseEntity<Election> getElectionByName(@PathVariable String name) {
        return ResponseEntity.ok(electionService.getElectionName(name));
    }

    // Update an Election
    @PutMapping("/{id}")
    public ResponseEntity<Election> updateElection(@PathVariable Long id, @RequestBody Election election) {
        return ResponseEntity.ok(electionService.updateElection(id, election));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElection(@PathVariable Long id) {
        electionService.deleteElection(id);
        return ResponseEntity.noContent().build();
    }
}
