package com.skillstorm.decorator.example1;

//Client code
public class DecoratorExample {
	public static void main(String[] args) {
		// Create a basic person
		Person basicPerson = new BasicPerson();

		// Decorate the person with additional clothing
		Person personWithTShirt = new TShirt(basicPerson);
		Person personWithJeans = new Jeans(personWithTShirt);
		Person fullyDressedPerson = new Sneakers(personWithJeans);

		// Output the final result
		fullyDressedPerson.wear();
	}
}
