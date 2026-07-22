package com.safa.blog_api_project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                .title("Blog API Projesi")
                        .version("1.0.0")
                        .description("Bu API; blog yazıları, kategoriler, etiketler, kullanıcılar ve yorumlar için geliştirilmiş temel CRUD operasyonlarını içerir.")
        );
    }
}
