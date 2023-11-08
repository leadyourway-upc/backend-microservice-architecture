package pe.edu.leadyourway.rentalmicroservice.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.leadyourway.rentalmicroservice.domain.model.commands.CreateRentCommand;
import pe.edu.leadyourway.rentalmicroservice.domain.model.queries.GetAllRentsQuery;
import pe.edu.leadyourway.rentalmicroservice.domain.model.queries.GetRentByIdQuery;
import pe.edu.leadyourway.rentalmicroservice.domain.services.RentCommandService;
import pe.edu.leadyourway.rentalmicroservice.domain.services.RentQueryService;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources.CreateRentResource;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources.RentResource;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.transform.CreateRentCommandFromResourceAssembler;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.transform.RentResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping(value= "api/v1/rents", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rents", description = "Rents Management Endpoints")
public class RentsController {
    private final RentCommandService rentCommandService;
    private final RentQueryService rentQueryService;

    public RentsController(RentCommandService rentCommandService, RentQueryService rentQueryService) {
        this.rentCommandService = rentCommandService;
        this.rentQueryService = rentQueryService;
    }

    @PostMapping("")
    public ResponseEntity<RentResource> createRent(@RequestBody CreateRentResource resource) {
        var createRentCommand = CreateRentCommandFromResourceAssembler.toCommandFromResource(resource);
        var rentId = rentCommandService.handle(createRentCommand);

        var getRentByIdQuery = new GetRentByIdQuery(rentId);
        var rent = rentQueryService.handle(getRentByIdQuery);

        var rentResource = RentResourceFromEntityAssembler.toResourceFromEntity(rent);
        return new ResponseEntity<>(rentResource, HttpStatus.CREATED);
    }

    @GetMapping("{rentId}")
    public ResponseEntity<RentResource> getRentById(@PathVariable Long rentId) {
        var getRentByIdQuery = new GetRentByIdQuery(rentId);
        var rent = rentQueryService.handle(getRentByIdQuery);

        var rentResource = RentResourceFromEntityAssembler.toResourceFromEntity(rent);

        return new ResponseEntity<>(rentResource, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<RentResource>> getAllRents() {
        var getAllRentsQuery = new GetAllRentsQuery();
        var rents = rentQueryService.handle(getAllRentsQuery);

        var rentResources = rents.stream().map(RentResourceFromEntityAssembler::toResourceFromEntity).toList();

        return new ResponseEntity<>(rentResources, HttpStatus.OK);
    }
}
