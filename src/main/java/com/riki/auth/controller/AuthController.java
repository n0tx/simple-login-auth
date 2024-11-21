package com.riki.auth.controller;

import com.riki.auth.dto.AuthRequest;
import com.riki.auth.dto.AuthResponse;
import com.riki.auth.model.AuthToken;
import com.riki.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponse<AuthToken>> login(@RequestBody AuthRequest request) {
        String token = authService.login(request.getUsername(), request.getPassword());
        if (token != null) {
            return ResponseEntity.ok(new AuthResponse<>(
                    "success", "Login successful", new AuthToken(token)
            ));
        }
        return ResponseEntity.status(401).body(new AuthResponse<>(
                "error", "Invalid username or password", null
        ));
    }

    // Authentication Endpoint
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse<String>> authenticate(@RequestBody AuthToken token) {
        boolean isValid = authService.authenticate(token.getToken());
        if (isValid) {
            return ResponseEntity.ok(new AuthResponse<>(
                    "success", "Authentication successful", "You are authenticated!"
            ));
        }
        return ResponseEntity.status(403).body(new AuthResponse<>(
                "error", "Invalid or expired token", null
        ));
    }
}

