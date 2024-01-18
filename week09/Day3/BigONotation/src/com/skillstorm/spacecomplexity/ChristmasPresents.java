package com.skillstorm.spacecomplexity;

public class ChristmasPresents {

	public static void main(String[] args) {
		// 1 present for each other person
		// Assume each present takes 1 sqr foot to make the math easy
		int people = 3;
		int presents = people * (people - 1);
		System.out.println(presents + " cubic ft");

		people = 6;
		presents = people * (people - 1);
		System.out.println(presents + " cubic ft");
		// The average bedroom is 132 squr ft ,x

		people = 12;
		presents = people * (people - 1);
		System.out.println(presents + " cubic ft");

		people = 24;
		presents = people * (people - 1);
		System.out.println(presents + " cubic ft");
	}

}
