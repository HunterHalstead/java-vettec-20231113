package com.skillstorm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeCreateExamples {
	
	public static void main(String[] args) {
		// 3 Ways to Create Dates and DateTimes: now, of, from
		
		// LocalDate
		// now
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		LocalTime rightNow = LocalTime.now();
		System.out.println(rightNow);
		
		LocalDateTime nowNow = LocalDateTime.now();
		System.out.println(nowNow);
		
		// of
		LocalDate tomorrow = LocalDate.of(2024, Month.JANUARY, 17);
		System.out.println(tomorrow);
		
		
		// from
		LocalDateTime original = LocalDateTime.now();
		
		LocalDate copy = LocalDate.from(original); // 1
		
//		LocalDateTime copyCopy = LocalDateTime.from(copy); // 2 DateTimeException
		
		
		
		
		
		
		// 4th Way to Create Dates and Times is .parse(str)
		// If not specified, the parser expects the ISO formats:
		//   ISO_LOCAL_DATE expects yyyy-MM-dd
		//   ISO_LOCAL_TIME expects HH:mm:ss or HH:mm
		//   ISO_LOCAL_DATE_TIME yyyy-MM-ddTHH:mm:ss or yyyy-MM-ddTHH:mm
		
		// LocalTime
		
		// LocalDateTime
		LocalDateTime test = LocalDateTime.parse("2024-01-16t11:40:14.400"); // will this work?
		System.out.println(test);
	}

}
