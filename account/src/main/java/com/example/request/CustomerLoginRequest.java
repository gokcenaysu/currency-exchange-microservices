package com.example.request;

public record CustomerLoginRequest(
        String email,
        String password
) {
}
