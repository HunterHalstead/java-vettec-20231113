package com.skillstorm;

public class TryWithResourcesExample {
	
	public static void main(String[] args) throws Exception {
		// Try-with-resources
	}

}

class Door implements AutoCloseable {
	
	String name;
	boolean closed; // default false
	
	public Door(String name) {
		this.name = name;
	}

	@Override
	public void close() throws Exception {
		
	}
	
	public void open() {
		
	}
	
	@Override
	public String toString() {
		return name + " door is " + (!closed ? "not " : " ") + "closed";
	}
	
}