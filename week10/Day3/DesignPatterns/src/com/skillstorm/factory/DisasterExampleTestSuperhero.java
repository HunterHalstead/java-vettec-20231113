package com.skillstorm.factory;

public class DisasterExampleTestSuperhero {
	
	public static void main(String[] args) {
		System.out.println("Help! The bridge is collapsing!");
		// Ask for factory for a superhero
		try {
				Superhero hero = SuperHeroFactory.getSuperhero();
				System.out.println("Don't worry " + superhero.getName() + " is here to save the day!");
		} (catch SuperherosException e) {
			System.out.println(e.getMessage());
		}
	}

}
