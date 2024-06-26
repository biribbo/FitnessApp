package com.example.FitnessApp.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class FirebaseAuthenticationToken extends AbstractAuthenticationToken {

    private final String uid;

    public FirebaseAuthenticationToken(String uid) {
        super(null);
        this.uid = uid;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.uid;
    }
}

