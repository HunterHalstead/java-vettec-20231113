package com.skillstorm.review;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Appointment {
	
	// From assignment
	private ZonedDateTime start;
	private Duration duration;
	
	// Create a scheduling Assistant
	static class SchedulingAssistant {
		static List<Appointment> possible = new ArrayList<>();
		static {
			LocalDate today = LocalDate.now();
			Duration d = Duration.ofHours(1);
			LocalTime time1 = LocalTime.of(8, 0);
			ZoneId here = ZoneId.systemDefault();
			ZonedDateTime start = ZonedDateTime.of(today.atTime(time1), here);
			
			for (int t = 9; t < 18; t++) { // 8am to 5pm
				start = start.plus(d);
				if (t == 12) {
					continue;
				}
				possible.add(new Appointment(start, d)); // add appt every hour
			}
		}
		
		// Given two a list of appointments (one for each person)
		// Give me a list of possible meeting times
		public List<Appointment> availableAppts(List<Appointment> person1s, List<Appointment> person2s) {
			List<Appointment> available = new ArrayList<>();
			Collections.copy(available, possible);
			outer: 
			for (Appointment a : possible) { // this loops nx
				for (Appointment p1: person1s) { // this loops mx
					if (hasOverlap(a, p1)) {
						available.remove(a); // this line runs how many times? nxm
						continue outer;
					}
				}
				for (Appointment p2: person2s) { // this runs px
					if (hasOverlap(a, p2)) {
						available.remove(a); // this line runs how many times? nxp
						continue outer;
					}
				}
			}
			return available; 
		} // n*m + n*p --> n*n + n*n --> 2n^2 --> O(n^2)
		
		public boolean hasOverlap(Appointment a, Appointment b) {
			// check if they have the same start time
			if (a.start.toInstant().equals(b.start.toInstant())) {
				return true;
			}
			
			if (a.start.isBefore(b.start)) {
				// check if a ends after b starts
				return a.end().isAfter(b.start);
			} else {
				// check if b ends after a starts
				return b.end().isAfter(a.start);
			}
			
		}
		
	}
	
	public Appointment(ZonedDateTime start, Duration duration) {
		super();
		this.start = start;
		this.duration = duration;
	}
	
	public ZonedDateTime end() {
		return start.plus(duration);
	}


	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE MMMM d 'at' h:mm a z");
		return duration.toMinutes() + "min appointment on " + start.format(dtf);
	}

	public ZonedDateTime getStart() {
		return start;
	}

	public void setStart(ZonedDateTime start) {
		this.start = start;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Appointment other = (Appointment) obj;
		if (duration == null) {
			if (other.duration != null) {
				return false;
			}
		} else if (!duration.equals(other.duration)) {
			return false;
		}
		if (start == null) {
			if (other.start != null) {
				return false;
			}
		} else if (!start.equals(other.start)) {
			return false;
		}
		return true;
	}
	
}
