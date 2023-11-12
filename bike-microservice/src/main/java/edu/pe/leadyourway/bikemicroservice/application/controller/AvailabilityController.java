package edu.pe.leadyourway.bikemicroservice.application.controller;

import edu.pe.leadyourway.bikemicroservice.domain.model.Availability;
import edu.pe.leadyourway.bikemicroservice.domain.service.AvailabilityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/availabilities")
@Tag(name = "AvailabilitiesController", description = "Avaialabilities Management Endpoints")
public class AvailabilityController {
    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @Transactional(readOnly = true)
    @GetMapping("{availabilityId}")
    @Operation(
        summary="Get Availability by Id",
        description = "Get Availability by bicycle Id"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Availability found",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Availability.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Availability not found"
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid id"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal Server Error"
        )
    })
    public ResponseEntity<Availability> getAvailabilityById(@PathVariable(name = "availabilityId") Long availabilityId) {
        return new ResponseEntity<Availability>(availabilityService.getById(availabilityId), HttpStatus.OK);
    }
}
