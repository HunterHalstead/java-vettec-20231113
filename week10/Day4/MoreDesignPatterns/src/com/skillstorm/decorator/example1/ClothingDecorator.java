package com.skillstorm.decorator.example1;

//Decorator abstract class
abstract class ClothingDecorator implements Person {
	protected Person person;

	public ClothingDecorator(Person person) {
		this.person = person;
	}

	@Override
	public void wear() {
		person.wear();
	}
}


