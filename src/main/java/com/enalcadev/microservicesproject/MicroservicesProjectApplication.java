package com.enalcadev.microservicesproject;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroservicesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesProjectApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.info( new Info()
						.title("Microservices Project")
						.version("1.0.0")
						.description("Test microservices with spring boot"));
	}
}
