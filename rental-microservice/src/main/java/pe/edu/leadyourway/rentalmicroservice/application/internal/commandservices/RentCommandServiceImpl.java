package pe.edu.leadyourway.rentalmicroservice.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.leadyourway.rentalmicroservice.domain.model.commands.CreateRentCommand;
import pe.edu.leadyourway.rentalmicroservice.domain.services.RentCommandService;
import pe.edu.leadyourway.rentalmicroservice.infrastructure.persistence.jpa.repositories.RentRepository;

@Service
public class RentCommandServiceImpl implements RentCommandService {
    private final RentRepository rentRepository;

    public RentCommandServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Long handle(CreateRentCommand command) {

        return null;
    }
}
