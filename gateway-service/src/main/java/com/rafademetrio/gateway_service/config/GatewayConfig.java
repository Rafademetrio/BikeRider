package com.rafademetrio.gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("auth-service", r-> r.path("/auth/**").uri("lb:/bikerider-auth")) //routes to  authentication.
                .route("product-service", r -> r.path("/api/products/**")
                        //TODO.filters(f -> f.filter(jwtAuthenticationFilter())) // Aplica filtro JWT
                        .uri("lb://bikerider-product"))
                .route("order-service", r -> r.path("/api/orders/**")
                        //TODO.filters(f -> f.filter(jwtAuthenticationFilter()))
                        .uri("lb://bikerider-order"))

                .route("user-service", r -> r.path("/api/users/**")
                        //TODO.filters(f -> f.filter(jwtAuthenticationFilter()))
                        .uri("lb://bikerider-user"))
                .build();
    }


}
