package pe.edu.leadyourway.rentalmicroservice.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record BicycleId(Long bicycleId) {
    public BicycleId() {
        this(0L);
    }

    public BicycleId {
        if (bicycleId < 0) {
            throw new IllegalArgumentException("BicycleId id cannot be negative");
        }
    }
}
