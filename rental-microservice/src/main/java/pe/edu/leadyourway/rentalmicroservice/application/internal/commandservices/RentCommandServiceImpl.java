package pe.edu.leadyourway.rentalmicroservice.application.internal.commandservices;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import pe.edu.leadyourway.rentalmicroservice.application.internal.outboundservices.ExternalBikeService;
import pe.edu.leadyourway.rentalmicroservice.domain.model.agreggates.Rent;
import pe.edu.leadyourway.rentalmicroservice.domain.model.commands.CreateRentCommand;
import pe.edu.leadyourway.rentalmicroservice.domain.services.RentCommandService;
import pe.edu.leadyourway.rentalmicroservice.infrastructure.persistence.jpa.repositories.RentRepository;

@Service
public class RentCommandServiceImpl implements RentCommandService {
    private final ExternalBikeService externalBikeService;
    private final RentRepository rentRepository;

    public RentCommandServiceImpl(ExternalBikeService externalBikeService, RentRepository rentRepository) {
        this.externalBikeService = externalBikeService;
        this.rentRepository = rentRepository;
    }

    @Override
    public Long handle(CreateRentCommand command) {

        var bicycle = externalBikeService.fetchBicycleById(command.bicycleId());

        var rent = new Rent(command.bicycleId(), command.rentStartDate(),command.rentEndDate(), command.rentPrice());

        rentRepository.save(rent);

        return rent.getId();
    }
}
