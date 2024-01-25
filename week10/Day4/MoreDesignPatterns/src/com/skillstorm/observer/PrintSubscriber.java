package com.skillstorm.observer;

public class PrintSubscriber implements Observer {
	
	

	@Override
	public void update(Object o) {
		System.out.println("> Print < " + o);
	}

	@Override
	public String toString() {
		return "PrintSubscriber";
	}
	
	

}
