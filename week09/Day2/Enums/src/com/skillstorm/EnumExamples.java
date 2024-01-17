package com.skillstorm;
import static com.skillstorm.Season.*; // Static import of Enums is a good place to use wildcard
public class EnumExamples {
	public static void main(String[] args) {
		System.out.println(SUMMER);
		System.out.println(WINTER);
		System.out.println(FALL);
		System.out.println(SPRING);
		
		Answer.NO.hesitate();
		Answer.YES.hesitate();
		
		Answer ans = Answer.NO;
		
		switch (ans) { // enum type implied by switch value
// Invalid cases:
//      case Answer.NO:
//		case 1:
//		case "NO":
// Valid cases:
			case NO:
				System.out.println("Pretty please?");
				break;
			case YES:
				System.out.println("Thanks!");
				break;
			default:
				System.out.println("huh?");
			
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
