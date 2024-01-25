package com.skillstorm.builder;

public class TestHouseBuilder {
	
	public static void main(String[] args) {
		HouseBuilder builder = new HouseBuilder();
		
		builder.setFloors("carpet");
		
		House myHouse = builder.build();
		
		System.out.println(myHouse);
	}

}
