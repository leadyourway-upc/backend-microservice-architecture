package pe.edu.leadyourway.rentalmicroservice.infrastructure.documentation.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI learningPlatformOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("LeadYourWay Rental Service API")
                        .description("LeadYourWay Rental Service API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("LeadYourWay API wiki Documentation")
                        .url("https://leadyourway-api.wiki.github.io/docs"));
    }
}