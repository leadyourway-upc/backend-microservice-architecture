package pe.edu.leadyourway.rentalmicroservice.domain.service;

import pe.edu.leadyourway.rentalmicroservice.domain.model.entity.Rent;

import java.util.List;

public interface RentService {
    Rent create(Rent rent);
    List<Rent> getAll();
    Rent getById(Long rentId);
    void delete(Long rentId);
    List<Rent> getByBicycleId(Long bicycleId);
}
