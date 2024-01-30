package com.skillstorm;

import java.io.File;
import java.time.Instant;
import java.util.Arrays;

public class CFileClassUtilities {
	
	public static void main(String[] args) {
		// Ways to get info about files/directories
		// 1. java.io.File -- has useful methods for getting info about the file
		// 2. java.nio.Path -- more powerful class for working with files and directories
		// 3. java.nio.Files -- utility class for working with Files and directories
		
		// Example 1: Get system's file seperator
		System.out.println(java.io.File.separator);
		
		File file = new File("hello.txt");
		// Example 2: Test if file exists
		System.out.println(file.exists());
		
		File file2 = new File("src/com/skillstorm/resources/hello.txt");
		System.out.println(file2.exists());
		
		// Example 3: Get information about the file
		System.out.println(file2.getAbsolutePath());
		System.out.println("Is absolute? " + file2.isAbsolute());
		System.out.println("Is file? " + file2.isFile());
		System.out.println("Is director? " + file2.isDirectory());
		
		File file3 = new File("src/com/skillstorm/resources/");
		System.out.println("File3 is directory? " + file3.isDirectory());
		System.out.println("Contents of directory: ");
		Arrays.asList(file3.list()).forEach(System.out::println);
		System.out.println("file3 parent directory is: " + file3.getParent());
		System.out.println("Last modified: " + Instant.ofEpochMilli(file3.lastModified()));
		System.out.println("Alphabet file size in bytes: " 
				+ new File("src/com/skillstorm/resources/words_alpha.txt").length() / 1_000_000.0 + " MB");
		
		System.out.println("Max file size we can measure is: " + Long.MAX_VALUE / 1_000_000_000_000L + " TB");
	}

}
