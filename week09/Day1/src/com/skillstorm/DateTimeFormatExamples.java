package com.skillstorm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatExamples {
	
	// Custom formatters
			// yyyy = 4 digit year
			// yy = 2 digit year
			// M = month ex: 8
			// MM = month ex: 08
			// MMM = month ex: Aug
			// MMMM = month ex: August
			// d = day of month
			// dd = day of month
			// D = day of year
			// E = weekday name Mon
			// EEEE = weekday name Monday
			// h = 12-hour clock ex: 8
			// hh = 12-hour clock ex: 08
			// H = 24-hour clock
			// m = minute of hour
			// s = seconds
			// a = AM or PM
			// z = timezone ex: GMT
	
	public static void main(String[] args) {
		// To format a time, hand in a formatter to the .format method
		LocalTime now = LocalTime.of(23, 30, 00);
		
		// 3 ways to create a DateTimeFormatter
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_TIME;
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		
		System.out.println(now.format(dtf));
		System.out.println(now.format(dtf1));
		System.out.println(now.format(dtf2));
		
		// To format a date using a custom pattern
		LocalDate endDate = LocalDate.of(2024, 3, 15);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d");
		System.out.println(endDate.format(formatter));
		System.out.println(formatter.format(endDate));
		
		// To format a zonedDateTime
		ZonedDateTime tomorrow = ZonedDateTime.now().plusDays(1);
		System.out.println(tomorrow.format(DateTimeFormatter.ofPattern("E MMM d' at 'h:mm a z")));
		
	}

}
