package com.skillstorm;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeManipulation {
	
	public static void main(String[] args) {
		LocalTime lunch = LocalTime.of(12, 00, 01);
		System.out.println(lunch);
		
		// Remember to save the return value because LocalTime is immutable
		lunch = lunch.plusNanos(1000000001);
		System.out.println(lunch.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
		
		System.out.println("Lunch is at " + lunch.getHour() + " hours");
		System.out.println("Lunch is at " + lunch.getMinute() + " minutes");
		System.out.println("Lunch is at " + lunch.getSecond() + " seconds and " 
									   + lunch.getNano() + " nanoseconds");
	}

}
