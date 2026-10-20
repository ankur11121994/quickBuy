package com.ecommerce.quickBuy.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST")
                .allowedHeaders("*");
    }
}
