package com.skillstorm.factory;

import java.util.List;

/**
 * This is a factory that returns an available superhero
 */
public class SuperheroFactory {
	
	// Properties
	static List<Superhero> heros;
	
	
	// Methods
	public Superhero getSuperhero() throws SuperheroException {
		for (Superhero hero : heros) {
			if (hero.isAvailable())
				return hero;
		}
		throw new SuperheroException("Sorry, no superheros are availalbe to save the day.");
	}
}
