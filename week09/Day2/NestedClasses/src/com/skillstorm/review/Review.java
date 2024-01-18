package com.skillstorm.review;

import java.util.function.Predicate;

public class Review {
	public class MemberInnerClass {
		
	}
	
	final static class StaticNestedClas {
		
	}
	
	public static void myMethod() {
		int x = 1; // effectively final
		
		// Anonymous inner class - creates an instance of an interface by giving the implementation in {}
		Predicate<Integer> myClass = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return x > t; // can only access local variables if they are final
			}
			
		};
		
		class LocalInnerClass {
			
		}
	}
}

class Review2 {
	
	public void isEffectivelyFinal(int a) {
		int b = 1;
		
		final int c = 2;
		
		b = 2;
		
		int d = 3;
		
		String s = "Hi";
		
		s.toUpperCase();
		
		
	}
	// Which are effectively final?
	// a - yes
	// b - no
	// c - yes
	// d - yes
	// s - yes
	
}
