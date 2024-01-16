package com.skillstorm;

import java.util.Date;

public class LegacyDateExamples {
	
	public static void main(String[] args) {
		// Do not use java.util.Date
		// Do not use deprecated methods
		// This is for demo purposes only
		Date today = new Date();
		System.out.println(today);
		
		Date tomorrow = new Date(2024, 1, 17);
		System.out.println(tomorrow); // Will this print Wed Jan 17 00:00:00 EST 2024?
		
		Date correctTomorrow = new Date(124, 0, 17);
		System.out.println(correctTomorrow);
		
		Date invalidDay = new Date(124, 5, 31);
		System.out.println(invalidDay);
	}
}
