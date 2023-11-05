package pe.edu.leadyourway.rentalmicroservice.application.internal.queryservices;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.leadyourway.rentalmicroservice.domain.exceptions.RentNotFoundException;
import pe.edu.leadyourway.rentalmicroservice.domain.model.agreggates.Rent;
import pe.edu.leadyourway.rentalmicroservice.domain.model.queries.GetAllRentsQuery;
import pe.edu.leadyourway.rentalmicroservice.domain.model.queries.GetRentByIdQuery;
import pe.edu.leadyourway.rentalmicroservice.domain.services.RentQueryService;
import pe.edu.leadyourway.rentalmicroservice.infrastructure.persistence.jpa.repositories.RentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RentQueryServiceImpl implements RentQueryService {

    private final RentRepository rentRepository;

    public RentQueryServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public List<Rent> handle(GetAllRentsQuery query) {
        return rentRepository.findAll();
    }

    @Override
    public Rent handle(GetRentByIdQuery query) {
        return rentRepository.findById(query.rentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rent with id [" + query.rentId() + "] not found"));

    }
}
