package com.madprints.budgetrpg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Minimal Spring Security configuration. Disables CSRF for simplicity and
 * permits all requests (authentication handled manually via session).
 */
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()
                .anyRequest().permitAll()
            )
            // Add a header writer for frame options instead of deprecated frameOptions()
            .headers(h -> h.addHeaderWriter(
                new org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter(
                    org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN
                )
            ))
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}