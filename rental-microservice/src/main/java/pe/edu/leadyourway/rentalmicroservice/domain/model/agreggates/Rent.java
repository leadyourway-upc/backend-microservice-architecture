package pe.edu.leadyourway.rentalmicroservice.domain.model.agreggates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pe.edu.leadyourway.rentalmicroservice.domain.model.valueobjects.BicycleId;
import pe.edu.leadyourway.rentalmicroservice.domain.model.valueobjects.CardId;

import java.time.LocalDate;


@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Rent extends AbstractAggregateRoot<Rent> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Embedded
    @Column(name = "bicycle_id")
    private BicycleId bicycleId;

    // @Getter
    // @Embedded
    // @Column(name = "card_id")
    // private CardId cardId;

    @Column(name="rent_start_date")
    private LocalDate rentStartDate;

    @Column(name="rent_end_date")
    private LocalDate rentEndDate;

    @Column(name="rent_price")
    private Double rentPrice;

    public Rent(Long bicycleId, LocalDate rentStartDate, LocalDate rentEndDate, Double rentPrice) {
        this.bicycleId = new BicycleId(bicycleId);
        this.rentStartDate = rentStartDate;
        this.rentEndDate = rentEndDate;
        this.rentPrice = rentPrice;
    }

    public Long getBicycleId() {
        return this.bicycleId.bicycleId();
    }
}
