package com.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/fallback")
public class FallbackController {

	@GetMapping("/coupons")
	public ResponseEntity<String> couponFallback() {
		log.error("쿠폰 서비스가 현재 이용 불가능합니다. 나중에 다시 시도해 주세요.");
		return ResponseEntity.status(503).body("쿠폰 서비스가 현재 이용 불가능합니다. 나중에 다시 시도해 주세요.");
	}

	@GetMapping("/api")
	public ResponseEntity<String> apiFallback() {
		log.error("API 서비스가 현재 이용 불가능합니다. 나중에 다시 시도해 주세요.");
		return ResponseEntity.status(503).body("API 서비스가 현재 이용 불가능합니다. 나중에 다시 시도해 주세요.");
	}

	@GetMapping("/auth")
	public ResponseEntity<String> authFallback() {
		log.error("인증 서비스가 현재 이용 불가능합니다. 나중에 다시 시도해 주세요.");
		return ResponseEntity.status(503).body("인증 서비스가 현재 이용 불가능합니다. 나중에 다시 시도해 주세요.");
	}
}