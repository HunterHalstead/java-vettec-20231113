package com.skillstorm.factory;

import java.util.ArrayList;
import java.util.List;

public class Superhero {
	private String name;
	private List<String> superpowers;
	boolean available = true;

	public Superhero(String name, List<String> superpowers) {
		super();
		this.name = name;
		this.superpowers = new ArrayList<>(superpowers);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSuperpowers() {
		return new ArrayList<>(superpowers);
	}

	public void setSuperpowers(List<String> superpowers) {
		this.superpowers = new ArrayList<>(superpowers);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Superhero [name=" + name + ", superpowers=" + superpowers + ", available=" + available + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((superpowers == null) ? 0 : superpowers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Superhero other = (Superhero) obj;
		if (available != other.available)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (superpowers == null) {
			if (other.superpowers != null)
				return false;
		} else if (!superpowers.equals(other.superpowers))
			return false;
		return true;
	}
}
