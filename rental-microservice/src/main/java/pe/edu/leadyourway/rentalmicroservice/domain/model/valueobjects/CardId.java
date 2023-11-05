package pe.edu.leadyourway.rentalmicroservice.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CardId(Long cardId) {
    public CardId() {
        this(0L);
    }

    public CardId {
        if (cardId < 0) {
            throw new IllegalArgumentException("Card id cannot be negative");
        }
    }
}
