package com.example.sweater.database.entities;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, AUTHOR, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}