package pe.edu.leadyourway.usermicroservice.interfaces.rest.resources;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserResource {

    @NotNull
    @Length(max = 50)
    private String firstName;

    @NotNull
    @Length(max = 50)
    private String lastName;

    @NotNull
    @Length(max = 50)
    private String email;

    @NotNull
    @Length(max = 50)
    private String password;

    @Length(max = 9)
    private String phoneNumber;

    @NotNull
    private LocalDate birthdate;

    private String imageUrl;
}
