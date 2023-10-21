package pe.edu.leadyourway.rentalmicroservice.resource;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateRentResource {
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
