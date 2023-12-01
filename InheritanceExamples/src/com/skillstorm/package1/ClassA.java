package com.skillstorm.package1;

public class ClassA {
	
	public int x = 1;
	protected int hmmm = 0;
/* default */ int y = 2;
	private int z = 3;
	
	
	public static void main(String[] args) {
		ClassA a = new ClassA();
		System.out.println(a.x);
		System.out.println(a.hmmm);
		System.out.println(a.y);
		System.out.println(a.z);
	}
	
	public void printProperties() {
		System.out.println(this.x);
		System.out.println(this.hmmm);
		System.out.println(this.y);
		System.out.println(this.z);
	}

}

// You can have multiple classes in the same file
//  but ONLY ONE can be public
class ClassD {
	public int i = 0;
	int j = 0;
	private int k = 0;
}

// DO NOT NEST CLASSES
// This will compile, but should only be used in certain cases
// we will not talk about till later
class ClassE {
	class ClassF {
		
	}
	
}
