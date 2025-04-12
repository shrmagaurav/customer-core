package com.learning.ecommerce.customercore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // ✅ Allow cookies & credentials
        config.setAllowedOrigins(List.of("http://localhost:8081", "http://localhost:3000")); // ✅ Allow multiple frontends
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")); // ✅ Allow preflight
        config.setAllowedHeaders(List.of("*")); // ✅ Allow all headers
        config.setExposedHeaders(List.of("Set-Cookie")); // ✅ Allow browser to access cookies

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}