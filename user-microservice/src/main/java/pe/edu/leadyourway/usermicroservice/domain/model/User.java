package pe.edu.leadyourway.usermicroservice.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 50)
    private String lastName;

    @NotNull
    @Length(max = 50)
    private String email;

    @NotNull
    @Length(max = 50)
    private String password;

    @Column(name="phone_number", length = 9)
    private String phoneNumber;

    @Column(name="birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name="image_url")
    private String imageUrl;
}
