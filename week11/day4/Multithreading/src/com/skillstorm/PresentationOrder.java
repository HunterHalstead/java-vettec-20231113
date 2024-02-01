package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PresentationOrder {
	
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.addAll(Arrays.asList("Hunter", "Rod", "Josh", "Sean", "Matt", "Sam"));
		Collections.shuffle(names);
		System.out.println(names);
	}

}
