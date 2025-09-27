package com.zapaticorp.auth_service.client;

import com.zapaticorp.auth_service.dto.ApiResponse;
import com.zapaticorp.auth_service.dto.LoginRequest;
import com.zapaticorp.auth_service.dto.RegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "viajero-service",
        url = "${viajero.service.url}"
)
public interface ViajeroClient {

    @PostMapping("/viajeros/register")
    ApiResponse<?> register(@RequestBody RegisterRequest request);

    @PostMapping("/viajeros/auth")
    ApiResponse<?> login(@RequestBody LoginRequest request);
}
