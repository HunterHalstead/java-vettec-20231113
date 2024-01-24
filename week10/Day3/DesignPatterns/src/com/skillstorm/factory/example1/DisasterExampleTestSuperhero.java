package com.skillstorm.factory.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisasterExampleTestSuperhero {

	public static void main(String[] args) {
		System.out.println("Help! The bridge is collapsing!");
		// Ask for factory for a superhero
		
		try {
			Superhero hero = SuperheroFactory.getSuperhero();
			System.out.println("Dont worry, " + hero.getName() + " is here to save the day");
		} catch (SuperheroException e) {

		}
		System.out.println("Help! The building is collapsing!");

		try {
			Superhero hero = SuperheroFactory.getSuperhero();
			System.out.println("Dont worry, " + hero.getName() + " is here to save the day");
		} catch (SuperheroException e) {

		}
		
		System.out.println("Help! The building is collapsing!");

		try {
			Superhero hero = SuperheroFactory.getSuperhero();
			System.out.println("Dont worry, " + hero.getName() + " is here to save the day");
		} catch (SuperheroException e) {
			System.out.println(e.getMessage());
		}

	}

}
