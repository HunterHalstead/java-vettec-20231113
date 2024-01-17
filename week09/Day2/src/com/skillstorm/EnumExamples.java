package com.skillstorm;

public class EnumExamples {
	public static void main(String[] args) {
		
		Answer.NO.hesitate();
		Answer.YES.hesitate();
		
		Answer ans = Answer.NO;
		
		switch (ans) { // enum type implied by switch value
		case /* Answer.NO */ NO:
			System.out.println("Pretty please?");
		case YES:
			System.out.println("Thanks!");
//		case 1:
//		case "NO":
			
		}

	}

	public void example1() {
		Season mySeason = Season.SUMMER;
		System.out.println(mySeason);

		Season otherSeason = Season.valueOf("WINTER");
		System.out.println(otherSeason);

		for (Season s : Season.values()) {
			System.out.println(s.ordinal() + "  " + s.name() + " " + s.hashCode());
		}

		System.out.println(mySeason.equals(otherSeason));
		System.out.println(mySeason == otherSeason);

		System.out.println(mySeason.equals(Season.SUMMER)); // Compares references
		System.out.println(mySeason == Season.SUMMER); // Compares references

	}
}
