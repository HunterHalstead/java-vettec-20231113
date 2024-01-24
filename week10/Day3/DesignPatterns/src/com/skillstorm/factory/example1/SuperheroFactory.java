package com.skillstorm.factory.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a factory that returns an available superhero
 */
public class SuperheroFactory {
	
	// Properties
	private static List<Superhero> heros;
	static {
		heros.add(
				new DCSuperhero("Superman", 
						new ArrayList<>(
								Arrays.asList("Super strength", 
												"flying", 
												"heat vision"))));
		heros.add(new MarvelSuperhero("Hulk", new ArrayList<>(
								Arrays.asList("Super strength"))));
	}
	
	public SuperheroFactory() {	}
	
	
	// Methods
	public static Superhero getSuperhero() throws SuperheroException {
		for (Superhero hero : heros) {
			if (hero.isAvailable()) {
				hero.setAvailable(false);
				return hero;
			}
		}
		throw new SuperheroException("Sorry, no superheros are availalbe to save the day.");
	}
	
}
