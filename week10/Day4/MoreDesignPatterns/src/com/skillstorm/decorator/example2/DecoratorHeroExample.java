package com.skillstorm.decorator.example2;

//Client code
public class DecoratorHeroExample {
	public static void main(String[] args) {
		// Create a basic hero
		Hero basicHero = new BasicHero();

		// Decorate the hero with additional weapons
		Hero heroWithSword = new Sword(basicHero);
		Hero heroWithBow = new Bow(heroWithSword);
		Hero powerfulHero = new MagicStaff(heroWithBow);
		
		

		// Output the final result
		powerfulHero.attack();
		
		Hero basicHero2 = new BasicHero();
		Hero basicHero2withBow = new Bow(basicHero2);
		Hero basicHero1withSwordandBow = new MagicStaff(basicHero2withBow);
		System.out.println();
		basicHero1withSwordandBow.attack();
		
	}
}

// Anti-pattern: Creating a subclass of Hero for every combinatoin of weapons

//Component interface
interface Hero {
	void attack();
}

//Concrete component
class BasicHero implements Hero {
	@Override
	public void attack() {
		System.out.println("Basic attack with bare hands");
	}
}

//Decorator abstract class
abstract class WeaponDecorator implements Hero {
	protected Hero hero;

	public WeaponDecorator(Hero hero) {
		this.hero = hero;
	}

	@Override
	public void attack() {
		hero.attack();
	}
}

//Concrete decorators
class Sword extends WeaponDecorator {
	public Sword(Hero hero) {
		super(hero);
	}

	@Override
	public void attack() {
		super.attack();
		System.out.println("Attacking with a sword");
	}
}

class Bow extends WeaponDecorator {
	public Bow(Hero hero) {
		super(hero);
	}

	@Override
	public void attack() {
		super.attack();
		System.out.println("Attacking with a bow");
	}
}

class MagicStaff extends WeaponDecorator {
	public MagicStaff(Hero hero) {
		super(hero);
	}

	@Override
	public void attack() {
		super.attack();
		System.out.println("Casting spells with a magic staff");
	}
}
