package com.gateway.config;

import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RouteLocatorConfig {
	private final SpringCloudCircuitBreakerFilterFactory circuitBreakerFilterFactory;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("bookstore-coupon", r -> r.path("/coupons/**")
				.filters(f -> f.circuitBreaker(c -> c.setName("couponCircuitBreaker")
					.setFallbackUri("forward:/fallback/coupons")))
				.uri("http://localhost:9494")
			)
			.route("bookstore-back", r -> r.path("/api/**")
				.filters(f -> f.circuitBreaker(c -> c.setName("backCircuitBreaker")
					.setFallbackUri("forward:/fallback/api")))
				.uri("http://localhost:8083")
			)
			.route("bookstore-account", r -> r.path("/auth/**")
				.filters(f -> f.circuitBreaker(c -> c.setName("accountCircuitBreaker")
					.setFallbackUri("forward:/fallback/auth")))
				.uri("http://localhost:8070")
			)
			.build();
	}

}
