package com.skillstorm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
	
	@Test
	void addOnes() {
		assertEquals(/* expected */ 2, /* actual */ Calculator.add(1, 1));
	}
	
	@Test
//	@Disabled // If we don't want to run this test right now
	void subtractOneFromTwo() {
		assertEquals(1, Calculator.subtract(2, 1));
	}
	
	@Test
	void divideByZero() {
		assertThrows(ArithmeticException.class, () -> {Calculator.divide(1, 0);});
	}

}
