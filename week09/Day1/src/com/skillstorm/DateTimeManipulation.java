package com.skillstorm;

import java.time.LocalTime;

public class DateTimeManipulation {
	
	public static void main(String[] args) {
		LocalTime lunch = LocalTime.of(12, 00);
		System.out.println(lunch);
		
		lunch.plusNanos(1);
		System.out.println(lunch);
	}

}
