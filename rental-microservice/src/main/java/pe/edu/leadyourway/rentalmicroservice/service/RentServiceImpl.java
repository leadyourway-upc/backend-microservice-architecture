package pe.edu.leadyourway.rentalmicroservice.service;

import org.springframework.stereotype.Service;
import pe.edu.leadyourway.rentalmicroservice.domain.model.entity.Rent;
import pe.edu.leadyourway.rentalmicroservice.domain.persistence.RentRepository;
import pe.edu.leadyourway.rentalmicroservice.domain.service.RentService;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    private static final String ENTITY = "Rent";
    private final RentRepository rentRepository;

    public RentServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Rent create(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getById(Long rentId) {
        return rentRepository.findById(rentId).orElse(null);
    }

    @Override
    public void delete(Long rentId) {
        rentRepository.deleteById(rentId);
    }

    @Override
    public List<Rent> getByBicycleId(Long bicycleId) {
        return rentRepository.findByBicycleId(bicycleId);
    }
}