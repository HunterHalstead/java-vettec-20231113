package com.skillstorm.localinnerclasses;

public class TrampolinePark {
	
	private String name;
	
	public static final double ENTRY_PRICE = 14.99;
	
	private int numTrampolines;
	
	public TrampolinePark(String name, int numTrampolines) {
		this.name = name;
		this.numTrampolines = numTrampolines;
	}
	
	///////////////////////////////////////////////////////////
	// Static Nested Class
	static abstract class Sale {
		private static int numAvailable = 100;
		
		public Sale() {
			numAvailable--;
		}
		
		abstract int dollarsOff();
		
		protected int getNumAvailable() {
			return numAvailable;
		}
	}
	///////////////////////////////////////////////////////////

	public double purchaseEntryPass(int age) {

		///////////////////////////////////////////////////////////
		// Local Inner Class
		class YouthDiscount extends Sale {
//			private static int count = 0; // cannot have static fields or methods
			
			@Override
			public int dollarsOff() {
				if (getNumAvailable() > 0)
					return 2;
				else
					return 0;
			}
			
			public void printInfo() {
				System.out.println("Number of trampolines is " + numTrampolines);
			}
			
			// can't have static methods in local classes
//			public static void printInfo() { 
//				System.out.println("Number of trampolines is " + numTrampolines); 
//			}
			
		}
		///////////////////////////////////////////////////////////
		Sale sale = new YouthDiscount();

		if (age < 12)
			return ENTRY_PRICE - sale.dollarsOff();

		return ENTRY_PRICE;
	}
	
	public int purchaseSocks(boolean isVeteran) {
		int normalPrice = 3;

		///////////////////////////////////////////////////////////
		// Local Inner Class
		class MilitaryDiscount extends Sale {
			
			@Override
			public int dollarsOff() {// TODO Auto-generated method stub
				return normalPrice;
			}

		}
		///////////////////////////////////////////////////////////
		
		if (isVeteran) {
			return normalPrice - new MilitaryDiscount().dollarsOff();
		}
		
		return normalPrice; // normal price

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumTrampolines() {
		return numTrampolines;
	}

	public void setNumTrampolines(int numTrampolines) {
		this.numTrampolines = numTrampolines;
	}

	@Override
	public String toString() {
		return name + " Trampoline Park has " + numTrampolines + "trampolines";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numTrampolines;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TrampolinePark other = (TrampolinePark) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (numTrampolines != other.numTrampolines) {
			return false;
		}
		return true;
	}
	

}
