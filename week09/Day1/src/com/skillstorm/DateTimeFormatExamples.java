package com.skillstorm;

import java.time.LocalTime;
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
		// To format a date, hand in a formatter to the .format method
		LocalTime now = LocalTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
		
		System.out.println(now.format(dtf));
		System.out.println(now.format(dtf2));
	}

}
