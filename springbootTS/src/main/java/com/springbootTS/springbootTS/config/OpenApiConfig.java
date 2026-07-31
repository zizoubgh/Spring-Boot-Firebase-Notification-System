package com.springbootTS.springbootTS.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;

import org.springframework.context.annotation.*;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("Firebase API")

                        .version("1.0")

                        .description("Spring Boot + Firebase Firestore"));

    }

}