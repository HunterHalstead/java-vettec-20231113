package com.skillstorm.observer;

public class DigitalSubscriber implements Observer {

	@Override
	public void update(Object o) {
		System.out.println("> Digital < " + o);
	}

	@Override
	public String toString() {
		return "DigitalSubscriber";
	}
	
	

}
