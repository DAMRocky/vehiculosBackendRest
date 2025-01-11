package com.patrick.vehiculosAPIRest.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*"); // Permite cualquier origen
        config.addAllowedHeader("*"); // Permite cualquier encabezado
        config.addAllowedMethod("*"); // Permite cualquier método (GET, POST, etc.)

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
