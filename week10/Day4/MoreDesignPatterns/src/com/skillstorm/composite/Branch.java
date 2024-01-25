package com.skillstorm.composite;

import java.util.ArrayList;
import java.util.List;

public class Branch implements Component {
	
	List<Component> subcomponents = new ArrayList<>();
	
	private int value;
	
	public Branch() { }
	
	public Branch(int num) {
		this.value = num;
	}

	@Override
	public int doWork() {
		// Do work and delegate work
		return value * value + 
				subcomponents.stream()
							.mapToInt(Component::doWork)
							.sum();
	}
	
	public String toString() {
		StringBuilder value = new StringBuilder();
		for (Component c : subcomponents) {
			value.append(c).append("\n  ");
		}
		return "Branch " + value + ": " + value;
	}
	

	public void add(Component c) {
		
		subcomponents.add(c);
	}
}
