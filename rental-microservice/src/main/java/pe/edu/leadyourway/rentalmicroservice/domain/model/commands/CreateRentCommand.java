package pe.edu.leadyourway.rentalmicroservice.domain.model.commands;

import java.time.LocalDate;

public record CreateRentCommand(
    Long bicycleId,
    LocalDate rentStartDate,
    LocalDate rentEndDate,
    Double rentPrice
) {

}
