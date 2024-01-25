package com.skillstorm.composite;

public class Leaf implements Component {
	
	int num;
	
	public Leaf(int num) {
		this.num = num;
	}

	@Override
	public int doWork() {
		return num * num;
	}
	
	public String toString() {
		return "Leaf " + num;
	}

}
