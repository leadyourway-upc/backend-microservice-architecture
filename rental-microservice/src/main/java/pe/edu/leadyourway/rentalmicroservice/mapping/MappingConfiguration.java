package pe.edu.leadyourway.rentalmicroservice.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("rentalMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public RentMapper rentMapper(){ return new RentMapper(); }
}
