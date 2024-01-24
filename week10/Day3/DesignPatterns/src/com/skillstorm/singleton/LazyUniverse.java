package com.skillstorm.singleton;

/**
 * LazyUniverse is a singleton.
 * 
 * It uses lazy initializatino so the instance is only loaded into memory
 *  the first time it is needed.
 */
public class LazyUniverse {
	
	private int age;
	
	private static LazyUniverse instance;

	private LazyUniverse() { }
	
	public LazyUniverse getInstance() {
		if (instance == null) 
			return instance = new LazyUniverse();
		return instance;
	}
	
	public int getAge() {
		return age;
	}

	public synchronized void incrementAge(int age) {
		this.age += age;
	}
	
	

}
