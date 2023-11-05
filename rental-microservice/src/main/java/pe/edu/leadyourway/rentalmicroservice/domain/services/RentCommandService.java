package pe.edu.leadyourway.rentalmicroservice.domain.services;

import pe.edu.leadyourway.rentalmicroservice.domain.model.commands.CreateRentCommand;

public interface RentCommandService {
    Long handle(CreateRentCommand command);
}
