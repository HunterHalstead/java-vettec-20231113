package com.skillstorm.factory.example2;

public class ShapeFactory {
	
		public static Shape getShape(int corners) {
			switch (corners) {
			case 3: return new Triangle(1, 1);
			case 4: return new Square(1, 1);
			default: throw new IllegalArgumentException("Unknown shape with " + corners + " corners");
			}
		}
	

}

abstract class Shape {
	
	private int numSides;
	
	private String name;
	
	public Shape(int numSides, String name) {
		this.name = name;
		this.numSides = numSides;
	}
	
	public abstract double getArea();

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class Triangle extends Shape {
	private int height;
	private int width;
	
	public Triangle(int height, int width) {
		super(3, "Triangle");
		this.height = height;
		this.width = width;
	}

	@Override
	public double getArea() {
		return height * width / 2.0;
	}

	@Override
	public String toString() {
		return this.getName() + " [height=" + height + ", width=" + width + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
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
		Triangle other = (Triangle) obj;
		if (height != other.height) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		return true;
	}
	
}

class Square extends Shape {
	private int height;
	private int width;
	
	public Square(int height, int width) {
		super(4, "Square");
		this.height = height;
		this.width = width;
	}

	@Override
	public double getArea() {
		return height * width;
	}

	@Override
	public String toString() {
		return "Square [height=" + height + ", width=" + width + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
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
		Square other = (Square) obj;
		if (height != other.height) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		return true;
	}
	
}

class Pentagon extends Shape {

	private int sideLength;

	public Pentagon(int sideLength) {
		super(5, "Pentagon");
		this.sideLength = sideLength;
	}


	public int getSideLength() {
		return sideLength;
	}


	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}


	@Override
	public String toString() {
		return "Pentagon [sideLength=" + sideLength + "]";
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sideLength;
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
		Pentagon other = (Pentagon) obj;
		if (sideLength != other.sideLength) {
			return false;
		}
		return true;
	}


	@Override
	public double getArea() {
		// A = 1/4 * sqrt( 5 * (5 + 2 * sqrt(5) ) ) * side^2
		return (1.0/4) * Math.sqrt( 5 * (5 + 2 * Math.sqrt(5) ) ) * Math.pow(sideLength, 2);
	}
	
	
	
}