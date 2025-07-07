package com.example.marketplace.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Konfiguration för Swagger-dokumentation
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI marketplaceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Marketplace API")
                        .description("Ett simpelt API för annonser med auto-login och validering")
                        .version("1.0"));
    }
}
