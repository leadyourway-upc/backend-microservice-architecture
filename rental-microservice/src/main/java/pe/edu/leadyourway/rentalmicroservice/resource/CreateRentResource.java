package pe.edu.leadyourway.rentalmicroservice.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class CreateRentResource {

    @NotNull
    private Long bicycleId;

    @NotNull
    private Long cardId;

    @NotNull
    private LocalDate rentStartDate;

    @NotNull
    private LocalDate rentEndDate;

    @NotNull
    private Double rentPrice;
}
