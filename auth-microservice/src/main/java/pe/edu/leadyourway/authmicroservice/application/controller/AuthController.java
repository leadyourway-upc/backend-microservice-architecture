package pe.edu.leadyourway.authmicroservice.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.leadyourway.authmicroservice.application.dto.AuthRequest;
import pe.edu.leadyourway.authmicroservice.application.dto.AuthResponse;
import pe.edu.leadyourway.authmicroservice.application.exception.AuthException;
import pe.edu.leadyourway.authmicroservice.domain.service.AuthService;

/**
 * Controller for handling authentication and user registration.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(
            summary = "Authenticate",
            description = "Authenticate a user",
            tags = {"auth"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "User authenticated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponse.class)),
                    links = @Link(name = "no links")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class)),
                    links = @Link(name = "no links")
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "User not authenticated",
                    content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class)),
                    links = @Link(name = "no links")
            )
    })
    public AuthResponse authenticate(@Valid @RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Register",
            description = "Register a user",
            tags = {"auth"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "User registered successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponse.class)),
                    links = @Link(name = "no links")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class)),
                    links = @Link(name = "no links")
            )
    })
    public ResponseEntity<String> register(@Valid @RequestBody AuthRequest authRequest) {
        authService.register(authRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
