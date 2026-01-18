package com.in28minutes.rest.webservices.restfulwebservices.jwt;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> authenticate(@RequestBody JwtTokenRequest request) {

        var authToken = new UsernamePasswordAuthenticationToken(
                request.username(),
                request.password()
        );

        var authentication = authenticationManager.authenticate(authToken);

        String jwt = tokenService.generateToken(authentication);

        return ResponseEntity.ok(new JwtTokenResponse(jwt));
    }

    // ✅ moved from file3
    public record JwtTokenRequest(String username, String password) {}

    // ✅ moved from file4
    public record JwtTokenResponse(String token) {}
}
