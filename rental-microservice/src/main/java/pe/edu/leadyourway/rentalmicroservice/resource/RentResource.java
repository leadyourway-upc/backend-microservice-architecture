package pe.edu.leadyourway.rentalmicroservice.resource;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class RentResource {
    private Long id;
    private Long bicycleId;
    private Long cardId;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private Double rentPrice;
}
