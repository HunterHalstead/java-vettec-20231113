package com.skillstorm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyToFile {
	
	// Don't use absolute paths, otherwise your code won't be portable
		// Instead use paths relative to the root of the project
		private static final String path = "./src/com/skillstorm/files/";
		
		public static void main(String[] args) throws FileNotFoundException, IOException {
			
			// Use a try-with-resources to make sure our file resources are released
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + "copy.txt"));
					BufferedReader br = new BufferedReader(new FileReader(path + "hello.txt"))) {
				// read from one file and write to another file
				String str;
				while ((str = br.readLine()) != null) {
					bw.write(str);
					bw.newLine();
				}
				System.out.println("done");
			}
			
		}


}
