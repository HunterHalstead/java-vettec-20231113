package com.skillstorm.groupwork.classes;

import java.util.Objects;

public class Road {
	
	private String name;

	public Road(String name) {
		super();
		this.name = name;
	}

	public Road() {
		super();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Road other = (Road) obj;
		return Objects.equals(name, other.name);
	}
	
}
