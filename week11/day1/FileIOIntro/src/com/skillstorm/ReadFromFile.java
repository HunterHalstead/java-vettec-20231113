package com.skillstorm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadFromFile {
	
	// Don't use absolute paths, otherwise your code won't be portable
	// Instead use paths relative to the root of the project
	private static final String path = "./src/com/skillstorm/files/"; // path to hello.txt from root directory of project
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Options for reading from files:
		// - InputStream - abstract
		// - FileInputStream - for bytes
		// - Reader - abstract 
		// - FileReader - for character data
		// - BufferReader - for added performance
		
		// Use a try-with-resources to make sure our file resources are released
		try (FileReader in = new FileReader(path + "hello.txt");
				BufferedReader br = new BufferedReader(in)) {
			// Read in the contents of a file and print to console
			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			System.out.println(">> After the loop str=" + str);
		}
	}

}
