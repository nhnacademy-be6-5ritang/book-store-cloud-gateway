package com.gateway;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookStoreCloudGatewayApplicationTests {

	@Test
	void mainMethodTest() {
		assertDoesNotThrow(() -> {
			BookStoreCloudGatewayApplication.main(new String[]{});
		});
	}

}
