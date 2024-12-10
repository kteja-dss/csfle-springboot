package com.confluent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KafkaSchemaRegistryApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void givenNonExistingClass_whenUsingForName_thenClassNotFound() {
		String className = "kafka-schema-registry-client-encryption-aws";
		Exception exception = assertThrows(ClassNotFoundException.class, () -> {
			Class.forName(className);

		});

		String expectedMessage = "kafka-schema-registry-client-encryption-aws";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
