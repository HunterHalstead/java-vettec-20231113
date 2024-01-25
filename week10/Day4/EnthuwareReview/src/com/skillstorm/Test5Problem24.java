package com.skillstorm;

public class Test5Problem24 {
	
	public static void main(String[] args) {
		String s1 = "String".replace('g','G');
		String s2 = "String".replace('g','G');
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		boolean a = "String".replace('g','G') == "String".replace('g','G');
		
		boolean b = "String".replace('g','G') == "String".replace('g','G');
		boolean c = "String".replace('g','G') == "String".replace('g','G');
		boolean d = "String".replace('g','G') == "String".replace('g','G');
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}

}
