package com.skillstorm.decorator.example3;

//Client code
public class DecoratorGreetingCardExample {
	public static void main(String[] args) {
		// Create a basic greeting card
		GreetingCard basicGreetingCard = new BasicGreetingCard();

		// Decorate the greeting card with additional features
		GreetingCard greetingCardWithFlowers = new FlowersDecorator(basicGreetingCard);
		GreetingCard greetingCardWithGiftCard = new GiftCardDecorator(greetingCardWithFlowers);
		GreetingCard greetingCardWithCashAndChocolates = new ChocolatesDecorator(
				new CashDecorator(greetingCardWithGiftCard));

		// Output the final result
		greetingCardWithCashAndChocolates.sendGreeting();
	}
}

//Component interface
interface GreetingCard {
	void sendGreeting();
}

//Concrete component
class BasicGreetingCard implements GreetingCard {
	@Override
	public void sendGreeting() {
		System.out.println("Sending a basic greeting card");
	}
}

//Decorator abstract class
abstract class GreetingCardDecorator implements GreetingCard {
	protected GreetingCard greetingCard;

	public GreetingCardDecorator(GreetingCard greetingCard) {
		this.greetingCard = greetingCard;
	}

	@Override
	public void sendGreeting() {
		greetingCard.sendGreeting();
	}
}

//Concrete decorators
class FlowersDecorator extends GreetingCardDecorator {
	public FlowersDecorator(GreetingCard greetingCard) {
		super(greetingCard);
	}

	@Override
	public void sendGreeting() {
		super.sendGreeting();
		System.out.println("with added flowers");
	}
}

class GiftCardDecorator extends GreetingCardDecorator {
	public GiftCardDecorator(GreetingCard greetingCard) {
		super(greetingCard);
	}

	@Override
	public void sendGreeting() {
		super.sendGreeting();
		System.out.println("with an attached gift card");
	}
}

class CashDecorator extends GreetingCardDecorator {
	public CashDecorator(GreetingCard greetingCard) {
		super(greetingCard);
	}

	@Override
	public void sendGreeting() {
		super.sendGreeting();
		System.out.println("with cash inside");
	}
}

class ChocolatesDecorator extends GreetingCardDecorator {
	public ChocolatesDecorator(GreetingCard greetingCard) {
		super(greetingCard);
	}

	@Override
	public void sendGreeting() {
		super.sendGreeting();
		System.out.println("with added chocolates");
	}
}
