package com.mootiv.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Log4j2
@Configuration
public class CorsConfig {

    @Value("${allowed.origins.url}")
    private String urlFront;

    private enum AllowedHttpMethods {
        GET, POST, PUT, PATCH, DELETE, OPTIONS
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                log.info("----------------------------- CORS -----------------------------");
                log.info("Configuración de CORS habilitada para el consumo desde el front-end");
                log.info("URL del front-end configurada: {}", urlFront);
                log.info("----------------------------------------------------------------");

                registry.addMapping("/**")
                        .allowedMethods(getAllowedHttpMethods())
                        .allowedHeaders("*")
                        .allowedOrigins(urlFront);


            }
        };
    }

    /**
     * Obtiene los métodos HTTP permitidos desde el ENUM 'AllowedHttpMethods' como un array de strings.
     *
     */
    private String[] getAllowedHttpMethods() {
        return Arrays.stream(AllowedHttpMethods.values())
                .map(Enum::name)
                .toArray(String[]::new);
    }
}

