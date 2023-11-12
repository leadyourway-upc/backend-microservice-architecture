package pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateRentResource(
        @NotNull
        Long bicycleId,
        @NotNull
        Long userId,
        @NotNull
        LocalDate rentStartDate,
        @NotNull
        LocalDate rentEndDate,
        @NotNull
        Double rentPrice
) {
}
