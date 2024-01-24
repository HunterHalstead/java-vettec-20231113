package com.skillstorm.singleton;

public class TestUniverse {
	
	public static void main(String[] args) {
//		Universe universe = new Universe(); // can't call the constructor
		
		Universe universe = Universe.getInstance();
		Universe universe2 = Universe.getInstance();
		
		System.out.println(universe);
		System.out.println(universe2);
		System.out.println(universe == universe2); // compare memory references
	}

}
