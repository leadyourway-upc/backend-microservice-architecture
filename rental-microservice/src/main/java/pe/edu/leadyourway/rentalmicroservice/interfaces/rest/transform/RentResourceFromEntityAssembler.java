package pe.edu.leadyourway.rentalmicroservice.interfaces.rest.transform;

import pe.edu.leadyourway.rentalmicroservice.domain.model.agreggates.Rent;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources.RentResource;

public class RentResourceFromEntityAssembler {
    public static RentResource toResourceFromEntity(Rent entity) {
        return new RentResource(entity.getId(), entity.getBicycleId(), entity.getRentStartDate(), entity.getRentEndDate(), entity.getRentPrice());
    }
}
