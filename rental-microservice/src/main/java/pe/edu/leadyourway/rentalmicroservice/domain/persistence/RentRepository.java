package pe.edu.leadyourway.rentalmicroservice.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.leadyourway.rentalmicroservice.domain.model.entity.Rent;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByBicycleId(Long bicycle_id);
}
