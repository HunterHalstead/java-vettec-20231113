package com.skillstorm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
	
	// Don't use absolute paths, otherwise your code won't be portable
	// Instead use paths relative to the root of the project
	private static final String path = "./src/com/skillstorm/files/";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Options for reading from files:
		// - InputStream is an abstract class that can't be initialized
		// - FileInputStream is for working with bytes
		// - FileReader is for working with characters
		// - BufferedReader is a decorator that improves performance by buffering reads
		
		// Use a try-with-resources to make sure our file resources are released
		try (FileReader in = new FileReader(path + "hello.txt");
			  BufferedReader buf = new BufferedReader(in)) {
			String str;
			while ((str = buf.readLine()) != null) {
				System.out.println(str);
			}
			System.out.println(">> After loop str = " + str);
		}
	}

}
