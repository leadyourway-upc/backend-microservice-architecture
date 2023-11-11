package edu.pe.leadyourway.bikemicroservice.application.outboundservice;

import edu.pe.leadyourway.bikemicroservice.domain.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "User-Service", url = "http://localhost:8080")
public interface ExternalUserService {
    @GetMapping("/api/v1/users/{userId}")
    User fetchUserById(@PathVariable Long userId);
}