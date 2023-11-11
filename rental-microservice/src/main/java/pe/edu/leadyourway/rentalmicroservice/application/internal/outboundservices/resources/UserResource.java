package pe.edu.leadyourway.rentalmicroservice.application.internal.outboundservices.resources;

import java.time.LocalDate;

public record UserResource (
       Long id,
       String firstName,
       String lastName,
       String email,
       String password,
       String phoneNumber,
       LocalDate birthdate,
       String imageUrl
) {

}
