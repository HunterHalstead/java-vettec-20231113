package com.skillstorm.factory.example2;

import java.util.Scanner;

public class TestShapeFactory {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many corners do you want the shape to have?");
		int corners = in.nextInt();
		// code here
		Shape shape = ShapeFactory.getShape(corners);
		System.out.println("Here is your " + shape);
		in.close();
	}

}
