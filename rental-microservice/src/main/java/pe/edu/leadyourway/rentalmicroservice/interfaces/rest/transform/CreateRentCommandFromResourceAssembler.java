package pe.edu.leadyourway.rentalmicroservice.interfaces.rest.transform;

import pe.edu.leadyourway.rentalmicroservice.domain.model.commands.CreateRentCommand;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources.CreateRentResource;

public class CreateRentCommandFromResourceAssembler {
    public static CreateRentCommand toCommandFromResource(CreateRentResource resource) {
        return new CreateRentCommand(resource.bicycleId(), resource.rentStartDate(), resource.rentEndDate(), resource.rentPrice());
    }
}
