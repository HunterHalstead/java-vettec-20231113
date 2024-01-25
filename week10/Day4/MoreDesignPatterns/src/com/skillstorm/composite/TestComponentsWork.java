package com.skillstorm.composite;

public class TestComponentsWork {
	
	public static void main(String[] args) {
		Branch root = new Branch(3);
		
		Branch b1 = new Branch(7);
		Branch b2 = new Branch(2);
		Branch b3 = new Branch(0);
		
		Leaf lf1 = new Leaf(1);
		Leaf lf2 = new Leaf(11);
		Leaf lf3 = new Leaf(10);
		
		root.add(b1);
		root.add(b2);
		
		b1.add(lf1);
		
		b2.add(lf2);
		b2.add(b3);
		
		b3.add(lf3);
		
		System.out.println(root);
		
		System.out.println(root.doWork());
	}

}
