package com.skillstorm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateGroups {
	

	private static final String path = "./src/com/skillstorm/files/";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<String> names = readNames("names.txt");
		System.out.println(names);
		List<List<String>> groups = randomizeGroups(names, 4);
		System.out.println(groups);
		writeGroups(groups, "groups.txt");
	}
	
	// Read in a list of names from a file
	public static List<String> readNames(String file) throws FileNotFoundException, IOException {
		List<String> names = new ArrayList<>();
		try (FileReader in = new FileReader(path + file);
				BufferedReader br = new BufferedReader(in)) {
			// Read in the contents of a file and add to list
			String name;
			while ((name = br.readLine()) != null) {
				if (!name.isEmpty())
					names.add(name.trim());
			}
		}
		return names;
	}
	
	// Create n randomized groups
	public static List<List<String>> randomizeGroups(List<String> names, int numGroups) {
		List<List<String>> groups = new ArrayList<>();
		Collections.shuffle(names);
		// Make an empty list for each group
		for (int i = 0; i < numGroups; i++) {
			groups.add(new ArrayList<>());
		}
		// Iterate through and put people in each group
		for (int i = 0; i < names.size(); i++) {
			int groupNum = i % numGroups;
			groups.get(groupNum).add(names.get(i));
		}
		return groups;
	}
	
	// Write the groups to a file
	public static void writeGroups(List<List<String>> groups, String file) throws IOException {
		/* Use format
		 * Group 1: Nasser, Rod, Sean
		 * Group 2: Josh, Carlos, Sam
		 * Group 3: Matt, Hunter
		 */
		try (PrintWriter writer = new PrintWriter(
									new BufferedWriter(
										new FileWriter(path + file)))) {
			for (int i = 0; i < groups.size(); i++) {
				writer.printf("Group %d: %s%n", i + 1, String.join(", ", groups.get(i)));
			}
		}
	}
}
