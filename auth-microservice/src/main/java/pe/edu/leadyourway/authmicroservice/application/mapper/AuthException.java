/*
package pe.edu.leadyourway.authmicroservice.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.leadyourway.authmicroservice.application.dto.AuthRequest;
import pe.edu.leadyourway.authmicroservice.application.dto.AuthResponse;
import pe.edu.leadyourway.authmicroservice.domain.model.Auth;

@Mapper
public interface AuthMapper {
    @Mapping(target = "token", source = "authToken")
    AuthResponse authToAuthResponse(Auth authToken);

    Auth authRequestToAuth(AuthRequest authRequest);
}
*/