package pe.edu.leadyourway.authmicroservice;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Leadyourway auth microservice API")
                        .description("Auth microservice API reference for developers")
                        .version("1.0"));
    }
}
