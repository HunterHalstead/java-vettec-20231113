package com.skillstorm;

public class Calculator {
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	/**
	 * Subtracts a from b
	 * @param a
	 * @param b
	 * @return returns the result from subtracting a from b
	 */
	public static int subtract(int a, int b) {
		return b - a;
	}
	
	public static int divide(int a, int b) {
		return a / b;
	}
	
	public static int multiply(int a, int b) {
		return a * b;
	}
	
	public static boolean even(int a) {
		if (a % 2 == 0)
			return true;
		else
			return false;
	}

}
