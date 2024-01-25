package com.skillstorm.decorator.example1;


class Jeans extends ClothingDecorator {
	public Jeans(Person person) {
		super(person);
	}

	@Override
	public void wear() {
		super.wear();
		System.out.println("Wearing jeans");
	}
}
