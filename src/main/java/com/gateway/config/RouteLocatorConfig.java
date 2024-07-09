
package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class RouteLocatorConfig {



    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("bookstore-coupon",
                p -> p.path("/coupons/**").uri("http://localhost:9494")
            )
            .route("bookstore-back",
                p -> p.path("/api/**").uri("http://localhost:8083")
            )
            .route("bookstore-account",
                p -> p.path("/auth/**").uri("http://localhost:8070")
            )
            .build();
    }



}
