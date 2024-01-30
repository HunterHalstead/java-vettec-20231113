package com.skillstorm;

public class ATryWithResources {
	
	/* Review: try-with-resources
	 * - like try-catch-finally
	 * - it will automatically close the resource for us
	 * - must be used with AutoCloseable object
	 * - it will close at the end of the try block before the catch or finally blocks
	 * - it closes the resources in the opposite order as they were opened
	 */
	public static void main(String[] args) {
		try (Stuff stuff = new Stuff();
				MoreStuff moreStuff = new MoreStuff()) {
			System.out.println("Doing something");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Something went wrong");
		} finally {
			System.out.println("Finally done.");
		}
		/*
		 * Should print:
		 * Creating stuff
		 * Creating more stuff
		 * Doing something
		 * ???
		 */
	}
	

}

class Stuff implements AutoCloseable {
	
	public Stuff() {
		System.out.println("Creating stuff");
	}

	@Override
	public void close() {
		System.out.println("Closing stuff");
	}
	
}

class MoreStuff implements AutoCloseable {
	
	public MoreStuff() {
		System.out.println("Creating more stuff");
	}

	@Override
	public void close() {
		System.out.println("Closing more stuff");
	}
	
}
