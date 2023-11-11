package pe.edu.leadyourway.rentalmicroservice.application.internal.outboundservices.resources;

public record BicycleResource(
    Long id,
    String bicycleName,
    String bicycleDescription,
    String bicyclePrice,
    String bicycleSize,
    String bicycleModel,
    String imageData,
    Long userId
) {
}
