package edu.pe.leadyourway.bikemicroservice.application.controller;

import edu.pe.leadyourway.bikemicroservice.domain.model.Bicycle;
import edu.pe.leadyourway.bikemicroservice.domain.service.BicycleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/bicycles")
@Tag(name = "BicyclesController", description = "Bicycles Management Endpoints")
public class BicycleController {
    private final BicycleService bicycleService;

    public BicycleController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    // URL: http://localhost:8080/api/leadyourway/v1/bicycles
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping
    @Operation(summary="Get Bicycles",description = "Get All Bicycles")
    public ResponseEntity<List<Bicycle>> getAllBicycles() {
        //print somethign
        System.out.println("getAllBicycles");
        return new ResponseEntity<List<Bicycle>>(bicycleService.getAllBicycles(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/leadyourway/v1/bicycles/{bicycleId}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/{bicycleId}")
    @Operation( summary = "Get Bicycle",description = "Get Bicycle by Id")
    public ResponseEntity<Bicycle> getBicycleById(@PathVariable(name = "bicycleId") Long bicycleId) {
        return new ResponseEntity<>(bicycleService.getBicycleById(bicycleId), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/leadyourway/v1/bicycles/available
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/available")
    @Operation(summary = "Get Available Bicycles", description = "Get All Available Bicycles")
    public ResponseEntity<List<Bicycle>> getAllAvailableBicycles(
            @RequestParam(name = "start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start_date,
            @RequestParam(name = "end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end_date
    ) {
        return new ResponseEntity<>(bicycleService.getAllAvailableBicycles(start_date, end_date), HttpStatus.OK);
    }


    // URL: http://localhost:8080/api/leadyourway/v1/bicycles/{userId}
    // Method: POST
/*    @Transactional
    @PostMapping("/{userId}")
    public ResponseEntity<Bicycle> createBicycleWithUserId(@PathVariable(name = "userId") Long userId, @RequestBody Bicycle bicycle) {
        return new ResponseEntity<Bicycle>(bicycleService.createBicycle(userId, bicycle), HttpStatus.CREATED);
    }*/

    // URL: http://localhost:8080/api/leadyourway/v1/bicycles/{bicycleId}
    // Method: PUT
    @Transactional
    @PutMapping("/{bicycleId}")
    @Operation(summary = "Update Bicycle", description = "Update Bicycle by Id")
    public ResponseEntity<Bicycle> updateBicycleByBicycleId(@PathVariable(name = "bicycleId") Long bicycleId, @RequestBody Bicycle bicycle) {
        return new ResponseEntity<>(bicycleService.updateBicycle(bicycleId, bicycle), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/leadyourway/v1/bicycles/{bicycleId}
    // Method: DELETE
    @Transactional
    @DeleteMapping("/{bicycleId}")
    @Operation(summary = "Delete Bicycle", description = "Delete Bicycle by Id")
    public ResponseEntity<String> deleteBicycleByBicycleId(@PathVariable(name = "bicycleId") Long bicycleId) {
        return new ResponseEntity<String>("Bicicleta eliminada correctamente", HttpStatus.OK);
    }
}
