package com.skillstorm.builder;

import java.util.ArrayList;
import java.util.List;

public class HouseBuilder {
	private String roof = "Wooden Shingle";
	private List<String> walls = new ArrayList<>();
	private String doors = "Oak";
	private String floors = "Hardwood";
	private String windows = "Double pane";
	
	public void setRoof(String roof) {
		this.roof = roof;
	}
	public void setWalls(List<String> walls) {
		this.walls = walls;
	}
	public void setDoors(String doors) {
		this.doors = doors;
	}
	public void setFloors(String floors) {
		this.floors = floors;
	}
	public void setWindows(String windows) {
		this.windows = windows;
	}
	
	public House build() {
		return new House(roof, walls, doors, floors, windows);
	}
}
