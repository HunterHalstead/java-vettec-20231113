package com.skillstorm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class GSingletonRevisited {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = null;
		Singleton4 singleton = Singleton4.getInstance();
		try {
			service = Executors.newFixedThreadPool(3);
			service.submit(() -> { 
				for (int i = 0; i < 10; i++) 
					singleton.increment();
				});
			service.submit(() -> { 
				for (int i = 0; i < 10; i++) 
					singleton.increment();
				});
			service.submit(() -> { 
				for (int i = 0; i < 10; i++) 
					singleton.increment();
				});
		} finally {
			service.shutdown();
		}
		service.awaitTermination(5, TimeUnit.SECONDS);
		System.out.println(singleton.getCounter());
	}
}

// Singleton with Eager initialization
class Singleton1 {
	private static final Singleton1 instance = new Singleton1();

	private Singleton1() {
	}

	public Singleton1 getInstance() {
		return instance;
	}

}

// Singleton with Lazy initialization
class Singleton2 {
	private volatile static Singleton2 instance; // prevents the compiler from allowing access to this object at the same time

	private Singleton2() {
	}

	public static /* synchronized */ Singleton2 getInstance() { // performance hit if whole method is synchronized
		if (instance == null) {
			synchronized (Singleton2.class) { // Why would you use a ReentrantLock instead? if you don't want to wait forever
				if (instance == null)
					instance = new Singleton2();
			}
		}
		return instance;
	}
}

// Singleton with counter methods
class Singleton3 {
	private int counter;
	private volatile static Singleton3 instance; // prevents the compiler from allowing access to this object at the same time
	private static Object obj = new Object();
	private Singleton3() {
	}

	public static /* synchronized */ Singleton3 getInstance() { // performance hit if whole method is synchronized
		if (instance == null) {
			synchronized (obj) {
				if (instance == null)
					instance = new Singleton3();
			}
		}
		return instance;
	}

	public int getCounter() {
		return counter;
	}

	public synchronized void increment() {
		this.counter++;
	}
	
	public synchronized void decrement() {
		this.counter--;
	}
	
}

//Singleton with counter methods
class Singleton4 {
	private AtomicInteger counter = new AtomicInteger(0); // 0
	private volatile static Singleton4 instance; // prevents the compiler from allowing access to this object at the same time
	private static Object obj = new Object();
	private Singleton4() {
	}

	public static /* synchronized */ Singleton4 getInstance() { // performance hit if whole method is synchronized
		if (instance == null) {
			synchronized (obj) {
				if (instance == null)
					instance = new Singleton4();
			}
		}
		return instance;
	}

	// returns the current value
	public int getCounter() {
		return counter.get();
	}

	// increments and returns the new value
	public int increment() {
		return this.counter.incrementAndGet();
	}
	
	// decrement and returns the new value
	public int decrement() {
		return this.counter.decrementAndGet();
	}
	
}