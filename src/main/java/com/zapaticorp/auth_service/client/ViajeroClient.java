package com.zapaticorp.auth_service.client;

import com.zapaticorp.auth_service.dto.ApiResponse;
import com.zapaticorp.auth_service.dto.LoginRequest;
import com.zapaticorp.auth_service.dto.RegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "viajero-service",
        url = "${viajero.service.url}"
)
@Component
public interface ViajeroClient {

    @PostMapping("/api/viajeros")
    ApiResponse<?> register(@RequestBody RegisterRequest request);

    @PostMapping("/api/viajeros/auth")
    ApiResponse<?> login(@RequestBody LoginRequest request);
}
