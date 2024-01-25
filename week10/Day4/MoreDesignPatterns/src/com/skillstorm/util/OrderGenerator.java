package com.skillstorm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OrderGenerator {
	static List<String> names = new ArrayList<>(
			Arrays.asList("Carlos", 
					     // "Hunter", 
					      "Josh", 
					      "Matt", 
					      "Nasser", 
					      "Rod", 
					      "Sam", 
					      "Sean"));

	public static void main(String[] args) {
		int n = 1;
		while (!names.isEmpty()) {
			System.out.println(n++ + ". " + names.remove(new Random().nextInt(names.size())));
		}
	}
}