package pe.edu.leadyourway.authmicroservice.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.atn.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.leadyourway.authmicroservice.application.dto.AuthRequest;
import pe.edu.leadyourway.authmicroservice.application.dto.AuthResponse;
import pe.edu.leadyourway.authmicroservice.domain.service.AuthService;

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
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponse.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "User not authenticated"
            )
    })
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
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
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthRequest.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request"
            )
    })
    public AuthRequest register(@RequestBody AuthRequest authRequest) {
        return authService.register(authRequest);
    }
}
