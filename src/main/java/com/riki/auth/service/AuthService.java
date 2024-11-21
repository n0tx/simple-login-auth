package com.riki.auth.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    // Dummy database
    private static final Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("admin", "password123"); // username: admin, password: password123
    }

    // Login Method
    public String login(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            // Generate a dummy token
            return "dummy-token-" + username;
        }
        return null;
    }

    // Autentikasi Method
    public boolean authenticate(String token) {
        // Dummy check for token validation
        return token != null && token.startsWith("dummy-token-");
    }
}

