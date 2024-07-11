package br.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("RESTfull API with Java and Spring Boot")
						.version("v1")
						.description("About my API...")
						.termsOfService("https://pub.manu-spring.com.br/api")
						.license(
								new License()
								.name("Apache 2.0")
								.url("https://pub.manu-spring.com.br/api"))
						);
	}
}
