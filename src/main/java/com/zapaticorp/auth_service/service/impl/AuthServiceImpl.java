package com.zapaticorp.auth_service.service.impl;

import com.zapaticorp.auth_service.client.ViajeroClient;
import com.zapaticorp.auth_service.config.JwtUtil;
import com.zapaticorp.auth_service.dto.ApiResponse;
import com.zapaticorp.auth_service.dto.AuthResponse;
import com.zapaticorp.auth_service.dto.LoginRequest;
import com.zapaticorp.auth_service.dto.RegisterRequest;
import com.zapaticorp.auth_service.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final ViajeroClient viajeroClient;

    public AuthServiceImpl(JwtUtil jwtUtil, ViajeroClient viajeroClient) {
        this.jwtUtil = jwtUtil;
        this.viajeroClient = viajeroClient;
    }

    // Registro de usuario
    @Override
    public AuthResponse register(RegisterRequest request) {
        ApiResponse<?> response = viajeroClient.register(request);

        if (!response.isSuccess()) {
            throw new RuntimeException("Error registrando viajero: " + response.getError());
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> data = (Map<String, Object>) response.getData();
        String email = data.get("email").toString();
        Integer id = (Integer) data.get("id");
        String token = jwtUtil.generateToken(email);

        return new AuthResponse(token, email, id);
    }

    // Login de usuario
    @Override
    public AuthResponse login(LoginRequest request) {
        ApiResponse<?> response = viajeroClient.login(request);

        if (!response.isSuccess()) {
            throw new RuntimeException("Error en login: " + response.getError());
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> data = (Map<String, Object>) response.getData();
        String email = data.get("email").toString();
        Integer id = (Integer) data.get("id");

        String token = jwtUtil.generateToken(email);
        return new AuthResponse(token, email, id);
    }

}
