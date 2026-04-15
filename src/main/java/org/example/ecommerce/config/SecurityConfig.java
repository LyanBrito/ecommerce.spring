package org.example.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/new").permitAll()
                        .requestMatchers("/users/delete/").permitAll()
                        .requestMatchers("/users/update/").permitAll()
                        .requestMatchers("/users/show/").permitAll()
                        .requestMatchers("/users/show").hasRole("ADMIN")
                        .requestMatchers("/products/create").hasRole("ADMIN")
                        .requestMatchers("/products/show").permitAll()
                        .requestMatchers("/products/show/").permitAll()
                        .requestMatchers("/orders/show").permitAll()
                        .requestMatchers("/orders/show/").permitAll()
                        .requestMatchers("/orders/create/").permitAll()
                        .requestMatchers("/orderItens/create/").permitAll()
                        .requestMatchers("/orderItens/show").permitAll()
                        .requestMatchers("/orderItens/show/").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
