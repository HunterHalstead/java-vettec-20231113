package com.skillstorm.pool;

import java.util.ArrayList;
import java.util.List;

import com.skillstorm.factory.Superhero;
import com.skillstorm.factory.SuperheroException;

/**
 * This class holds a pool of superheros that can be drawn from.
 */
public class SuperheroPool {
	
	// Properties
	private List<Superhero> heros;
	
	// Constructor
	public SuperheroPool(List<Superhero> heros) {	
		this.heros = new ArrayList<>(heros);
	}
	
	
	// Methods
	public Superhero getSuperhero() throws SuperheroException {
		for (Superhero hero : heros) {
			if (hero.isAvailable()) {
				hero.setAvailable(false);
				return hero;
			}
		}
		throw new SuperheroException("Sorry, no superheros are availalbe to save the day.");
	}

}
