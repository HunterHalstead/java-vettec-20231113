package com.skillstorm;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTimeMath {
	
	public static void main(String[] args) {
		// LocalDate LocalTime LocalDateTime has .until()
		LocalTime now = LocalTime.now();
		LocalTime eod = LocalTime.of(18, 0);
		System.out.println(now.until(eod, ChronoUnit.HOURS) + " Hours");
		// Get rid of the minutes for full hours
		System.out.println((now.until(eod, ChronoUnit.MINUTES) % 60)  + " Minutes");
		System.out.println((now.until(eod, ChronoUnit.SECONDS) % 60) + " Seconds");
		
		// Duration and Period has static method .between()
		System.out.println(Duration.between(now, eod));
		
		LocalDate today = LocalDate.now();
		LocalDate proj3Due = LocalDate.of(2024, 3, 15);
		System.out.println(Period.between(today, proj3Due));
		
		
	}

}
