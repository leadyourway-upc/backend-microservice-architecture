package edu.pe.leadyourway.bikemicroservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pe.leadyourway.bikemicroservice.infrastructure.entity.AvailabilityEntity;

import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<AvailabilityEntity, Long> {
    List<AvailabilityEntity> findByBicycleId(Long bicycle_id);
    List<AvailabilityEntity> findByBicycleIdAndAvailabilityType(Long bicycle_id, boolean availability_type);
    boolean existsByBicycleIdAndAvailabilityStartDateLessThanEqualAndAvailabilityEndDateGreaterThanEqual(Long bicycle_id, java.time.LocalDate availability_start_date, java.time.LocalDate availability_end_date);
}