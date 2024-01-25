package com.skillstorm.decorator.example1;

//Concrete decorators
class TShirt extends ClothingDecorator {
	public TShirt(Person person) {
		super(person);
	}

	@Override
	public void wear() {
		super.wear();
		System.out.println("Wearing a T-shirt");
	}
}