package pe.edu.leadyourway.rentalmicroservice.domain.services;

import pe.edu.leadyourway.rentalmicroservice.domain.model.agreggates.Rent;
import pe.edu.leadyourway.rentalmicroservice.domain.model.queries.GetAllRentsQuery;
import pe.edu.leadyourway.rentalmicroservice.domain.model.queries.GetRentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RentQueryService {
    List<Rent> handle(GetAllRentsQuery query);
    Rent handle(GetRentByIdQuery query);
}
