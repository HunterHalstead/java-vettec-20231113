package com.skillstorm.localinnerclasses;

public class RockClimbingGym {

	private final double DAY_PASS_PRICE = 22.99;

	abstract class Sale {
		abstract int dollarsOff();
	}

	public double purchaseDayPass(int age) {

		class YouthDiscount extends Sale {
//			private static int numCouponsAvailable = 100; // can't have static fields

			@Override
			public int dollarsOff() {// TODO Auto-generated method stub
				return 10;
			}

		}

		Sale sale = new YouthDiscount();

		if (age < 12)
			return DAY_PASS_PRICE - sale.dollarsOff();

		return DAY_PASS_PRICE;
	}
	
	public int purchaseClimbingShoes(boolean isVeteran) {
		int normalPrice = 210;
		class MilitaryDiscount extends Sale {

			@Override
			public int dollarsOff() {// TODO Auto-generated method stub
				return (int) (normalPrice * 0.5);
			}

		}
		if (isVeteran) {
			return normalPrice - new MilitaryDiscount().dollarsOff();
		}
		
		return normalPrice; // normal price

	}

}
