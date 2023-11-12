package pe.edu.leadyourway.apigateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "LeadYouWay API Gateway"))
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/rental-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://Rental-Service"))
				.route(r -> r.path("/bike-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://Bike-Service"))
				.route(r -> r.path("/user-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://User-Service"))
				.route(r -> r.path("/auth-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://Auth-Service"))
				.build();
	}
}
