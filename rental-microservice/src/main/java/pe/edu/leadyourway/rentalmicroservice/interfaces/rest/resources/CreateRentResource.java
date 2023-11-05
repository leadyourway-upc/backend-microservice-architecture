package pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateRentResource(
        Long bicycleId,
        LocalDate rentStartDate,
        LocalDate rentEndDate,
        Double rentPrice
) {
}
