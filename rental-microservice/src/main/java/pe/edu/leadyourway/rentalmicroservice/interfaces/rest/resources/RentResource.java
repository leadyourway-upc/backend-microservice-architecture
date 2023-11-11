package pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources;

import java.time.LocalDate;

public record RentResource(
        Long id,
        Long bicycleId,
        Long userId,
        LocalDate rentStartDate,
        LocalDate rentEndDate,
        Double rentPrice
) {
}
