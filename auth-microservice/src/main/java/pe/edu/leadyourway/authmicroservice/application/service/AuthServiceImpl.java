package pe.edu.leadyourway.authmicroservice.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.leadyourway.authmicroservice.application.dto.AuthRequest;
import pe.edu.leadyourway.authmicroservice.application.dto.AuthResponse;
import pe.edu.leadyourway.authmicroservice.domain.model.Auth;
import pe.edu.leadyourway.authmicroservice.domain.repository.AuthRepository;
import pe.edu.leadyourway.authmicroservice.domain.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        return AuthResponse.builder()
                .id(1L)
                .token(authRequest.getUsername())
                .build();
    }
    @Override
    public AuthResponse refreshToken(String token) {
        return null;
    }
    @Override
    public AuthRequest register(AuthRequest authRequest) {
        return AuthRequest.builder()
                .username(authRequest.getUsername())
                .password(authRequest.getPassword())
                .build();
    }
}
