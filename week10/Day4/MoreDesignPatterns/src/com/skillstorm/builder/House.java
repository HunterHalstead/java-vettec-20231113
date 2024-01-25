package com.skillstorm.builder;

import java.util.List;

public class House {
	
	private String roof;
	private List<String> walls;
	private String doors;
	private String floors;
	private String windows;
	public House(String roof, List<String> walls, String doors, String floors, String windows) {
		super();
		this.roof = roof;
		this.walls = walls;
		this.doors = doors;
		this.floors = floors;
		this.windows = windows;
	}
	@Override
	public String toString() {
		return "House [roof=" + roof + ", walls=" + walls + ", doors=" + doors + ", floors=" + floors + ", windows="
				+ windows + "]";
	}
	

}
