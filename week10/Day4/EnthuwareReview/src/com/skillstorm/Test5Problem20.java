package com.skillstorm;

import java.util.Observable;
import java.util.Observer;


public class Test5Problem20 {
	
	public static void main(String[] args) {
		 A a = new A() ;   B b = new B();
//		 Object o = b; Observer o2 = (B) o; // Option 4 debugged (needed explicit cast)
		 Object o = a; Observer ob = (Observer) o ; // Option 3 Runtime error (A is not a subtype of Observer)
	}
}

class A implements Runnable {

	@Override
	public void run() {

	}
}

class B extends A implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
}