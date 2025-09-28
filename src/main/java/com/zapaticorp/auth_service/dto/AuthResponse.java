package com.zapaticorp.auth_service.dto;

public class AuthResponse {
    private String token;
    private String email;
    private Integer id;

    public AuthResponse(String token, String email, Integer id) {
        this.token = token;
        this.email = email;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
