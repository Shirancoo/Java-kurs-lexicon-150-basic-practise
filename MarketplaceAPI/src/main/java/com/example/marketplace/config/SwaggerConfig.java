package com.example.marketplace.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//inställningar för Swagger så man kan testa API:et
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI skapaSwagger() {
        return new OpenAPI().info(new Info()
                .title("Marketplace API")
                .description("Ett API för annonser. Man loggar in automatiskt och det finns lite validering.")
                .version("1.0"));
    }
}
