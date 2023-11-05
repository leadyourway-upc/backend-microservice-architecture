package pe.edu.leadyourway.rentalmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RentalMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalMicroserviceApplication.class, args);
	}

}
