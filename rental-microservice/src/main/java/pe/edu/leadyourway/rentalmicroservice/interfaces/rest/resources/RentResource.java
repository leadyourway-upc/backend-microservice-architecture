package pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources;

import java.time.LocalDate;

public record RentResource(
        Long id,
        Long bicycleId,

        LocalDate rentStartDate,
        LocalDate rentEndDate,
        Double rentPrice
) {
}
