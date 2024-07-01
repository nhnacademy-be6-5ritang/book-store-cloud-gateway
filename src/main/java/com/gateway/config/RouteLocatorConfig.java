
package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class RouteLocatorConfig {


    public final RouterProperties routerProperties;



    @Bean
    public RouteLocator customRouteLocater(RouteLocatorBuilder builder) {





        return builder.routes()
               // .route("bookstore-backend",
               //
               //         p -> p.path(routerProperties.getBackendPath()).and().uri(routerProperties.getBackendUrl())
               //              )
                .route("bookstore-coupon",

                        p -> p.path(routerProperties.getCouponPath()).and().uri(routerProperties.getCouponUrl())
                )
                .build();


    }



}
