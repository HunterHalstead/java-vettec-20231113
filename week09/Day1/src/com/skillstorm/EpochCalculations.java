package com.skillstorm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneOffset;

public class EpochCalculations {
	
	public static void main(String[] args) {
		// Epoch - starts on Jan 1, 1970 00:00:00
		System.out.println(System.currentTimeMillis());
		
		// Java uses a long to store the milliseconds since the epoch
		System.out.println(Long.MAX_VALUE + " milliseconds");
		
		// What year will we run out of values?
		System.out.println("We will run out of numbers in " + Year.MAX_VALUE);
		System.out.println("We will run out of numbers on " + Instant.MAX);
		// Java has been around for          30 years
		// Humans have been around      300,000 years
		// Planet has been around 4,500,000,000 years
		// Sun will burn out in   2,000,000,000 years
		// Epoch long will run out  999,999,999 years

		// Unix time typically uses a signed integer to store number of seconds since the epoch
		// What year will they run out of values?
		LocalDateTime y2k = LocalDateTime.ofEpochSecond(Integer.MAX_VALUE, 0, ZoneOffset.UTC);
		System.out.println("Unix time systems will run out of numbers on: " + y2k);
	}

}
