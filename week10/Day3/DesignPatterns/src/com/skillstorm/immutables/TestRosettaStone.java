package com.skillstorm.immutables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRosettaStone {

	public static void main(String[] args) {
//		RosettaStone stone = new RosettaStone();
		List<Language> languages = new ArrayList<>(
				Arrays.asList(new Language("English"), 
								new Language("Spanish"), 
								new Language("Arabic")));
		RosettaStone stone = new RosettaStone("Hello! Hola! Marahaba!", languages);
		System.out.println(stone.getText());
//		stone.setText("bla bla bla");
		
		List<Language> copy = stone.getLanguages();
		System.out.println(stone.getLanguages());
		copy.add(new Language("French"));
		System.out.println("Copy of list: " + copy);
		System.out.println("Languages on RosettaStone: " + stone.getLanguages());
		
		languages.add(new Language("German"));
		System.out.println("Languages on RosettaStone: " + stone.getLanguages());
		
	}

}
