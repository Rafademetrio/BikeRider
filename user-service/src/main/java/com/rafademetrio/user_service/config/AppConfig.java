package com.rafademetrio.user_service.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                );
        return http.build();
    }

 */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // Permite tudo temporariamente
                )
                .addFilterBefore((request, response, chain) -> {
                    // Converter para HttpServletRequest
                    HttpServletRequest httpRequest = (HttpServletRequest) request;

                    // Forma moderna de obter headers (Spring Security 6+)
                    String headers = Collections.list(httpRequest.getHeaderNames())
                            .stream()
                            .map(name -> name + ": " + httpRequest.getHeader(name))
                            .collect(Collectors.joining(", "));

                    System.out.println("Headers recebidos: " + headers);
                    chain.doFilter(request, response);
                }, UsernamePasswordAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable()); // Desabilita CSRF para testes

        return http.build();
    }
    

}
