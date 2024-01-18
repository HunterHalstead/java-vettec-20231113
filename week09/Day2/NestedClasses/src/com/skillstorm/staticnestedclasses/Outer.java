package com.skillstorm.staticnestedclasses;

public class Outer {
	private static int x = 1;
	private int y = 2;
	
	public void printXs() {
		System.out.println("Outer.x = " + x);
		System.out.println("Inner.x = " + Inner.x);
	}
	
	public void printYs() {
		System.out.println("Outer.y = " + y);
		// Instances of Outer are not bound to an instance of Inner
//		System.out.println("Inner.y = " + Inner.y);
		Inner in = new Inner();
		System.out.println(in.y); // need an instance to access instance variables
	}
	
	static class Inner {
		private static int x = -1;
		int y = -2;
		
		public void printXs() {
			System.out.println("Outer.x = " + Outer.x);
			System.out.println("Inner.x = " + Inner.x);
		}
		
		public void printYs() {
			System.out.println("Inner's y = " + y);
			// instances of Inner are not bound to an instance of Outer
//			System.out.println("Outer.y = " + Outer.y);
//			System.out.println("Outer.y = " + Outer.this.y);
			Outer outer = new Outer(); 
			System.out.println("Outer's y = " + outer.y); // need an instance to access instance variables
		}
	}

}
