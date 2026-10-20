package com.ecommerce.quickBuy.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 👇 TELLS SPRING SECURITY TO HONOR YOUR MVC CORS CONFIGURATION
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // Your other security configurations (e.g., CSRF, Authorization)
                .csrf(csrf -> csrf.disable())
                // Your custom token verification filter must occur before the authorization filter
                //.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class) // Often disabled for stateless APIs (JWT)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().permitAll()
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 1. Specify your Angular frontend URL precisely (Do not use "*" if you pass credentials)
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));

        // 2. Allow the standard methods
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));

        // 3. Allow incoming custom headers (like Authorization for JWTs)
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With", "Accept"));

        // 4. If your Angular app passes cookies or tokens via Http Headers
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Apply globally
        return source;
    }
}
