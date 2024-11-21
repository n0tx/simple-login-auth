package com.riki.auth.model;


public class AuthToken {
    private String token;

    // Default constructor
    public AuthToken() {}

    public AuthToken(String token) {
        this.token = token;
    }

    // Getter and Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

