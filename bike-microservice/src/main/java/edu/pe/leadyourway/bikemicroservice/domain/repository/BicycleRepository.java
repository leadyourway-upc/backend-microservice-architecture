package edu.pe.leadyourway.bikemicroservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pe.leadyourway.bikemicroservice.infrastructure.entity.BicycleEntity;

@Repository
public interface BicycleRepository extends JpaRepository<BicycleEntity, Long> {
}