package com.skillstorm.anonymousclasses;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TestPerson {
	
	public static void main(String[] args) {
		Person bob = new Person("Bob", LocalDate.now().minusDays(1));
		Person sue = new Person("Sue", LocalDate.of(2000, Month.JANUARY, 1));
		
		Comparator<Person> comparator = new AgeComparator();
		System.out.println(comparator.compare(bob, sue) <= -1 ? "Sue is older than Bob" : 
								comparator.compare(bob, sue) ==  0 ? "Sue and Bob are the same age" :
									"Bob is older than Sue");
		
		Person jim = new Person("Jim", LocalDate.of(1950, Month.APRIL, 30));
		
		List<Person> people = new LinkedList<>(Arrays.asList(bob, jim, sue));
		people.sort(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge() - p2.getAge();
			}
		}.reversed());
		people.stream().forEach(System.out::println);
		
	}

}
