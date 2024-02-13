package com.skillstorm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTests {
	
	@Test
	void testSum() {
		int result = Calculator.sum(1, 1);
		assertEquals(2, result);
	}


}
