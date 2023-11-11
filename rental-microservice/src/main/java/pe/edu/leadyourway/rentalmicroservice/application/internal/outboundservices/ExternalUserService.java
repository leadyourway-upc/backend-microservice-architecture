package pe.edu.leadyourway.rentalmicroservice.application.internal.outboundservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.leadyourway.rentalmicroservice.application.internal.outboundservices.resources.UserResource;

@FeignClient(name = "User-Service", url = "http://localhost:8080")
public interface ExternalUserService {
    @GetMapping("/api/v1/users/{userId}")
    UserResource fetchUserById(@PathVariable Long userId);
}
