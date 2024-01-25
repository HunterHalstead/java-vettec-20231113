package com.skillstorm.decorator.example1;

//Concrete component
public class BasicPerson implements Person {
	@Override
	public void wear() {
		System.out.println("Basic clothing");
	}
}