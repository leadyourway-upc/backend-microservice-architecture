package pe.edu.leadyourway.authmicroservice.domain.service;

import pe.edu.leadyourway.authmicroservice.application.dto.AuthRequest;
import pe.edu.leadyourway.authmicroservice.application.dto.AuthResponse;

public interface AuthService {
    public abstract AuthResponse authenticate(AuthRequest authRequest);
    public abstract AuthResponse refreshToken(String token);
    public abstract AuthRequest register(AuthRequest authRequest);
}
