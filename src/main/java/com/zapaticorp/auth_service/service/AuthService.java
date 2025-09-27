package com.zapaticorp.auth_service.service;


import com.zapaticorp.auth_service.dto.AuthResponse;
import com.zapaticorp.auth_service.dto.LoginRequest;
import com.zapaticorp.auth_service.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
