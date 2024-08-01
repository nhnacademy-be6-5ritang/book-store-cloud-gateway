package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("bookstore-coupon", r -> r.path("/coupons/**")
				.uri("http://localhost:9494")
			)
			.route("bookstore-back", r -> r.path("/api/**")
				.uri("lb://book-store-back")
			)
			.route("bookstore-account", r -> r.path("/auth/**")
				.uri("http://localhost:8070")
			)
			.build();
	}

}
