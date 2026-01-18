package com.in28minutes.rest.webservices.restfulwebservices.user;


import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.in28minutes.rest.webservices.restfulwebservices.user.repository.AppUserRepository;



@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class SignupController {

    private final AppUserRepository repo;
    private final BCryptPasswordEncoder passwordEncoder;

    public SignupController(AppUserRepository repo, BCryptPasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {

        if (repo.existsByUsername(request.username())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        String hashedPassword = passwordEncoder.encode(request.password());

        repo.save(new AppUser(
                request.username(),
                hashedPassword,
                "ROLE_USER"
        ));

        return ResponseEntity.ok("Signup successful");
    }
}

record SignupRequest(String username, String password) {}
