package com.skillstorm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.stream.Stream;

public class Assignment {

	private static final String path = "./src/com/skillstorm/files/";

	public static void main(String[] args) {
		String longest = findLongestWithStream();
		System.out.println("Longest word is " + longest + " with " + longest.length() + " characters");
		String longest2 = findLongestWithParallelStream();
		System.out.println("Longest word is " + longest2 + " with " + longest2.length() + " characters");
	}

	public static String findLongestWithStream() {
		String longestWord = "";
		// Use Stream methods by turning the lines into the file into a Stream using
		// Files utility class
		try (Stream<String> lines = Files.lines(Paths.get(path + "words_alpha.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter(path + "long_words.txt"))) {
			// Now you can use Stream methods on the lines
			long start = System.currentTimeMillis();
			longestWord = lines.filter(word -> word.length() > 25).peek(word -> {
				try {
					writer.write(word);
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).max(Comparator.comparing(String::length)) // returns Optional
					.orElse(""); // Get value in Optional or "" if not present
			long end = System.currentTimeMillis();
			System.out.println("Normal execution: " + (Duration.ofMillis(end - start).get(ChronoUnit.NANOS) / 1000000.0 )+ " milliseconds");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return longestWord;
	}
	
	public static String findLongestWithParallelStream() {
		String longestWord = "";
		// Use Stream methods by turning the lines into the file into a Stream using
		// Files utility class
		try (Stream<String> lines = Files.lines(Paths.get(path + "words_alpha.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter(path + "long_words.txt"))) {
			// Now you can use Stream methods on the lines
			long start = System.currentTimeMillis();
			longestWord = lines.parallel().filter(word -> word.length() > 25).peek(word -> {
				try {
					writer.write(word);
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).max(Comparator.comparing(String::length)) // returns Optional
					.orElse(""); // Get value in Optional or "" if not present
			long end = System.currentTimeMillis();
			System.out.println("Parallel execution: " + (Duration.ofMillis(end - start).get(ChronoUnit.NANOS)) + " milliseconds");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return longestWord;
	}

}
