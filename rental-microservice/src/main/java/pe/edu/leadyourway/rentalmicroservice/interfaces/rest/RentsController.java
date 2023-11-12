package pe.edu.leadyourway.rentalmicroservice.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.leadyourway.rentalmicroservice.domain.exceptions.RentNotFoundException;
import pe.edu.leadyourway.rentalmicroservice.domain.model.commands.CreateRentCommand;
import pe.edu.leadyourway.rentalmicroservice.domain.model.queries.GetAllRentsQuery;
import pe.edu.leadyourway.rentalmicroservice.domain.model.queries.GetRentByIdQuery;
import pe.edu.leadyourway.rentalmicroservice.domain.services.RentCommandService;
import pe.edu.leadyourway.rentalmicroservice.domain.services.RentQueryService;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources.CreateRentResource;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources.RentResource;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.resources.UpdateRentResource;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.transform.CreateRentCommandFromResourceAssembler;
import pe.edu.leadyourway.rentalmicroservice.interfaces.rest.transform.RentResourceFromEntityAssembler;

import java.util.ArrayList;
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
    @Operation(summary = "Create a Rent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created Rent", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RentResource.class))
            }),
            @ApiResponse(responseCode = "400", description = "One or more fields are invalid",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content),
    })
    public ResponseEntity<RentResource> createRent(@RequestBody CreateRentResource resource) {
        var createRentCommand = CreateRentCommandFromResourceAssembler.toCommandFromResource(resource);
        var rentId = rentCommandService.handle(createRentCommand);

        var getRentByIdQuery = new GetRentByIdQuery(rentId);
        var rent = rentQueryService.handle(getRentByIdQuery);

        var rentResource = RentResourceFromEntityAssembler.toResourceFromEntity(rent);
        return new ResponseEntity<>(rentResource, HttpStatus.CREATED);
    }

    @GetMapping("{rentId}")
    @Operation(summary = "Get a Rent by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Rent", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RentResource.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = {
                    @Content
            }),
            @ApiResponse(responseCode = "404", description = "Rent not Found", content = {
                    @Content
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content),
    })
    public ResponseEntity<RentResource> getRentById(@PathVariable Long rentId) {
        var getRentByIdQuery = new GetRentByIdQuery(rentId);
        var rent = rentQueryService.handle(getRentByIdQuery);

        var rentResource = RentResourceFromEntityAssembler.toResourceFromEntity(rent);

        return new ResponseEntity<>(rentResource, HttpStatus.OK);
    }

    @GetMapping()
    @Operation(summary = "Get All Rents")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Rents", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema( schema = @Schema( implementation = RentResource.class)))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content),
    })
    public ResponseEntity<List<RentResource>> getAllRents() {
        var getAllRentsQuery = new GetAllRentsQuery();
        var rents = rentQueryService.handle(getAllRentsQuery);

        var rentResources = rents.stream().map(RentResourceFromEntityAssembler::toResourceFromEntity).toList();

        return new ResponseEntity<>(rentResources, HttpStatus.OK);
    }

    @PutMapping("{rentId}")
    @Operation(summary = "Update a Rent by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update Rent", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RentResource.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = {
                    @Content
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content),
    })
        public ResponseEntity<RentResource> updateRentById(@PathVariable Long rentId,  @RequestBody UpdateRentResource resource) {

        var getRentByIdQuery = new GetRentByIdQuery(rentId);
        var rent = rentQueryService.handle(getRentByIdQuery);

        var rentResource = RentResourceFromEntityAssembler.toResourceFromEntity(rent);
        return new ResponseEntity<>(rentResource, HttpStatus.OK);
    }
}
