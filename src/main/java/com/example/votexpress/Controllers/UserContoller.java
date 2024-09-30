package com.example.votexpress.Controllers;

import com.example.votexpress.Models.Election;
import com.example.votexpress.Models.User;
import com.example.votexpress.ServiceLayers.ElectionService;
import com.example.votexpress.ServiceLayers.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "userapi")
public class UserContoller {
    private final UserService userService;
    private final ElectionService electionService;

    public UserContoller(UserService userService, ElectionService electionService) {
        this.userService = userService;
        this.electionService = electionService;
    }

    // Register a user
    @PostMapping(value = "/registeruser")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser.getFirstname());
    }

    // Find user by email
    @GetMapping(path = "/{email}")
    public ResponseEntity<Map<String, String>> findUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findByUserByEmail(email);  // Assign result to Optional<User>

        if (user.isPresent()) {  // Check if user is found
            Map<String, String> response = new HashMap<>();
            response.put("email", user.get().getEmail());
            return ResponseEntity.ok(response);  // Return email if found
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Return 404 if not found
        }
    }

    @GetMapping(path = "id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
       return ResponseEntity.ok(userService.getUserById(id));
    }
}
