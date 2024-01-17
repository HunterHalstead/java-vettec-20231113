package com.skillstorm.anonymousclasses;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Person {
	private String name;
	
	private final LocalDate DOB;
	
	public Person(String name, LocalDate dob) {
		this.name = name;
		this.DOB = dob;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", DOB=" + DOB + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DOB == null) ? 0 : DOB.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (DOB == null) {
			if (other.DOB != null) {
				return false;
			}
		} else if (!DOB.equals(other.DOB)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public LocalDate getDOB() {
		return this.DOB;
	}
	
	public int getAge() {
		return Period.between(this.DOB, LocalDate.now()).getYears();
	}
	
}

class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// compare ages
		// if dob after 
		if (o1.getDOB().isAfter(o2.getDOB())) {
			return -1;
		}
		if (o1.getDOB().isBefore(o2.getDOB())) {
			return 1;
		}
		return 0;
	}
	
}