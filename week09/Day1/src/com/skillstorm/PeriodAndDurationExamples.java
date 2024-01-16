package com.skillstorm;

import java.time.Duration;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PeriodAndDurationExamples {
	
	public static void main(String[] args) {
		// Period is for years, months, days
		Period oneYear = Period.ofYears(1);
		System.out.println(oneYear);
		
		Period longTime = Period.of(100, 2, 1);
		System.out.println(longTime);
		
		
		// Duration is for hours, minutes, seconds
		Duration twoDays = Duration.ofDays(2);
		System.out.println(twoDays);
		
		Duration oneHour30min = (Duration.ofHours(1)).ofMinutes(30);
		System.out.println(oneHour30min);
		//-----------------------------------------
		// Common Pitfall: You cannot chain static .ofXXXs() methods
		
		Period halfAYearAndADay = Period.ofDays(1).ofMonths(6);
		System.out.println(halfAYearAndADay);
		
		
		// ----------------------------------------------------------
		// Reminder: You can chain LocalDate .plusXXX().minusXXX().withXXX()
		
		
		
		
		
		//-----------------------------------------
		// Common Pitfall: Period uses the concept of a day not 24 hours
		// Sun, Mar 10 2024 2am EST + 1 day 
		
		ZonedDateTime beforeDS = ZonedDateTime.of(2024, 3, 9, // March 9, 2024
													13, 00, 00, 00, // 1pm 
														ZoneId.systemDefault());
		System.out.println(beforeDS);
		
		System.out.println(beforeDS.plus(Period.ofDays(1))); 
		System.out.println(beforeDS.plus(Duration.ofDays(1)));
		
		
		
	}

}
