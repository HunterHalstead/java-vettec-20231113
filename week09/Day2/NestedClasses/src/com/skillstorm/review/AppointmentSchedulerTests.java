package com.skillstorm.review;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.skillstorm.review.Appointment.SchedulingAssistant;

public class AppointmentSchedulerTests {
	
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		Duration d = Duration.ofHours(1);
		LocalTime time1 = LocalTime.of(10, 0);
		LocalTime time2 = LocalTime.of(13, 0);
		ZoneId here = ZoneId.systemDefault();
		ZonedDateTime start1 = ZonedDateTime.of(today.atTime(time1), here);
		ZonedDateTime start2 = ZonedDateTime.of(today.atTime(time2), here);
		
		Appointment appt1 = new Appointment(start1, d);
		Appointment appt2 = new Appointment(start1, d);
		SchedulingAssistant sca = new SchedulingAssistant();
		
		System.out.println("Appt1 and Appt2 has overlap: " + sca.hasOverlap(appt1, appt2));
		
		Appointment appt3 = new Appointment(start2, d);
		System.out.println("Appt1 and Appt3 has overlap: " + sca.hasOverlap(appt1, appt3));
		System.out.println("Appt3 and Appt1 has overlap: " + sca.hasOverlap(appt3, appt1));
		
	}

}
