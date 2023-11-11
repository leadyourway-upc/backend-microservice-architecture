package edu.pe.leadyourway.bikemicroservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    String phoneNumber;
    LocalDate birthdate;
    String imageUrl;
}
