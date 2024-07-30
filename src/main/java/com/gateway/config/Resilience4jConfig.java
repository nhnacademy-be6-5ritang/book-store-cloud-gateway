package com.gateway.config;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import lombok.RequiredArgsConstructor;

/**
 * @author 이경헌
 * Resilience4j 서킷 브레이커를 설정하는 구성 클래스입니다.
 */
@Configuration
@RequiredArgsConstructor
public class Resilience4jConfig {
	/**
	 * 사용자 지정 서킷 브레이커 설정을 구성합니다.
	 *
	 * @return 사용자 지정 서킷 브레이커 팩토리
	 */
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> circuitBreakerFactoryCustomizer() {
		CircuitBreakerConfig config = CircuitBreakerConfig.custom()
			.slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
			.slidingWindowSize(10)                              // 통계건수
			.minimumNumberOfCalls(5)                            // 최소요청횟수
			.failureRateThreshold(60)                           // 실패율
			.waitDurationInOpenState(Duration.ofSeconds(10))    // Circuit Breaker 유지시간
			.build();
		return factory -> factory.configure(builder -> builder.circuitBreakerConfig(config)
			.build(), "circuitBreakerFactoryCustomizer");
	}
}
