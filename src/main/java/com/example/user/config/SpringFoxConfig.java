package com.example.user.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringFoxConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("the title").version("0.0").description("My API")
                        .contact(new Contact().name("Fred").url("http://gigantic-server.com").email("Fred@gigagantic-server.com")));
    }


}