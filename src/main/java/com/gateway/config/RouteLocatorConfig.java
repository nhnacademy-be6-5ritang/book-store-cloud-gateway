package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RouteLocatorConfig {

    @Bean
    @Profile("prod")
    public RouteLocator prodRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bookstore-coupon", r -> r.path("/coupons/**")
                        .uri("http://localhost:9494")
                )
                .route("bookstore-back", r -> r.path("/api/**")
                        .uri("lb://book-store-back") // 로드밸런싱 활성화
                )
                .route("bookstore-account", r -> r.path("/auth/**")
                        .uri("http://localhost:8070")
                )
                .build();
    }

    @Bean
    @Profile("dev")
    public RouteLocator devRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bookstore-coupon", r -> r.path("/coupons/**")
                        .uri("http://localhost:9494")
                )
                .route("bookstore-back", r -> r.path("/api/**")
                        .uri("http://localhost:8083") // 로드밸런싱 비활성화, dev 환경의 로컬 서버
                )
                .route("bookstore-account", r -> r.path("/auth/**")
                        .uri("http://localhost:8070")
                )
                .build();
    }
}
