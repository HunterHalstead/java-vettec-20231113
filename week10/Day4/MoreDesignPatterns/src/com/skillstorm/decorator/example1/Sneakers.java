package com.skillstorm.decorator.example1;

class Sneakers extends ClothingDecorator {
	public Sneakers(Person person) {
		super(person);
	}

	@Override
	public void wear() {
		super.wear();
		System.out.println("Wearing sneakers");
	}
}