package com.skillstorm;

public class BSuppressedExceptions {
	
	public static void main(String[] args) {
		try (BrokenStuff tv = new BrokenStuff("tv");
				BrokenStuff fridge = new BrokenStuff("fridge");
				  BrokenStuff dishwasher = new BrokenStuff("dishwasher")) {
			System.out.println("Doing something with stuff");
			throw new RuntimeException("Something went wrong");
		} catch (IllegalStateException e) {
			System.out.println("caught: " + e.getMessage());
			for (Throwable t : e.getSuppressed()) {
				System.out.println("suppressed: " + t.getMessage());
			}
		} 
//		finally {
//			throw new RuntimeException("Finally went wrong");
//		}
		System.out.println("End of main");
	}

}

class BrokenStuff implements AutoCloseable {
	
	String name;
	
	public BrokenStuff(String name) {
		this.name = name;
		System.out.println(">> Creating a " + name);
	}

	@Override
	public void close() throws IllegalStateException {
		System.out.println(">> Closing " + name);
		throw new IllegalStateException(name + " is broken");
	}
	
}