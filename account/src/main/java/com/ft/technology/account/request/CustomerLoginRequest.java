package com.ft.technology.account.request;

public record CustomerLoginRequest(
        String email,
        String password
) {
}
