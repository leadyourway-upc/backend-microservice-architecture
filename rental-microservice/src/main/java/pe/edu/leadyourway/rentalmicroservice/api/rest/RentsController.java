package pe.edu.leadyourway.rentalmicroservice.api.rest;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pe.edu.leadyourway.rentalmicroservice.domain.service.RentService;
import pe.edu.leadyourway.rentalmicroservice.mapping.RentMapper;
import pe.edu.leadyourway.rentalmicroservice.resource.CreateRentResource;
import pe.edu.leadyourway.rentalmicroservice.resource.RentResource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/rents")
@Tag(name = "Rents", description = "Rents Information")
public class RentsController {
    private final RentService rentService;
    private final RentMapper mapper;

    public RentsController(RentService rentService, RentMapper mapper) {
        this.rentService = rentService;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @GetMapping("/{rentId}")
    @Operation(summary = "Get Rent By Id")
    public ResponseEntity<RentResource> getRentById(@PathVariable(name = "rentId") Long rentId) {
        return new ResponseEntity<>(mapper.toResource(rentService.getById(rentId)), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/rents/bicycle/{bicycleId}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/bicycle/{bicycleId}")
    @Operation(summary = "Get All Rents by Bicycle Id")
    public ResponseEntity<Page<RentResource>> getRentByBicycleId(@PathVariable(name = "bicycleId") Long bicycleId, Pageable pageable) {
        return new ResponseEntity<>(mapper.modelListPage(rentService.getByBicycleId(bicycleId), pageable), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/rents
    // Method: POST
    @Transactional
    @PostMapping
    @Operation(summary = "Create a Rent")
    public ResponseEntity<RentResource> createRent(@RequestBody CreateRentResource resource) {
        return new ResponseEntity<>(mapper.toResource(rentService.create(mapper.toModel(resource))) , HttpStatus.CREATED);
    }

    // URL: http://localhost:8080/api/v1/rents/{rentId}
    // Method: DELETE
    @Transactional
    @DeleteMapping("/{rentId}")
    @Operation(summary = "Delete a Rent by Id")
    public ResponseEntity<Void> deleteRent(@PathVariable(name = "rentId") Long rentId) {
        rentService.delete(rentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
