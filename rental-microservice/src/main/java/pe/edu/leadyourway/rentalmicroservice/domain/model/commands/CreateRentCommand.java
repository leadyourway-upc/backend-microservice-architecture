package pe.edu.leadyourway.rentalmicroservice.domain.model.commands;

import java.time.LocalDate;

public record CreateRentCommand(
    Long bicycleId,
    Long userid,
    LocalDate rentStartDate,
    LocalDate rentEndDate,
    Double rentPrice
) {

}
