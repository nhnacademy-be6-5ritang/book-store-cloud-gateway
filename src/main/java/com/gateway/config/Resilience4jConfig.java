package com.gateway.config;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class Resilience4jConfig {

	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> myCB() {
		CircuitBreakerConfig config = CircuitBreakerConfig.custom()
			.slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
			.slidingWindowSize(10)                              // 통계건수
			.minimumNumberOfCalls(2)                            // 최소요청횟수
			.failureRateThreshold(60)                           // 실패율
			.waitDurationInOpenState(Duration.ofSeconds(10))    // Circuit Breaker 유지시간
			.build();
		return factory -> factory.configure(builder -> builder.circuitBreakerConfig(config)
			.build(), "mycb");
	}
}
