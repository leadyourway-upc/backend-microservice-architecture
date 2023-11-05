package pe.edu.leadyourway.rentalmicroservice.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.leadyourway.rentalmicroservice.domain.model.agreggates.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

}
