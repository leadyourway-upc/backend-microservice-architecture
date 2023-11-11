package pe.edu.leadyourway.rentalmicroservice.application.internal.outboundservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.leadyourway.rentalmicroservice.application.internal.outboundservices.resources.BicycleResource;

@FeignClient(name = "Rental-Service", url = "http://localhost:8080")
public interface ExternalBikeService {

    @GetMapping("/api/v1/bicycles/{bicycleId}")
    BicycleResource fetchBicycleById(@PathVariable Long bicycleId);
}
