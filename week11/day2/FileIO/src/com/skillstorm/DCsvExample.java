package com.skillstorm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DCsvExample {
	
	// Challenge: Reverse the process and instead write to a file a given list of users
	// continue to append do not overwrite previous data

	private static final File path = new File("src/com/skillstorm/resources");

	public static void main(String[] args) {
		List<User> users = readFromCSV("MOCK_DATA.csv");
		users.forEach(System.out::println);
	}

	private static boolean isCSV(String name) {
		// Example: mock_data.csv should return true
		// hello.txt should return false
		// hello.txt.csv should return true
		// hello.csv.txt should return false
		// hello.ccsv should return false
		return name.endsWith(".csv");
	}

	public static List<User> readFromCSV(String name) {
		if (name == null || name.isEmpty() || !isCSV(name)) {
			throw new IllegalArgumentException("File must be a CSV");
		}
		// Print out all the lines in the file
		// Options for reading from a file
		// - InputStream
		// - Reader
		// - FileInputStream
		// - FileReader
		// - BufferedInputStream
		// - BufferedReader
		List<User> users = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(path, name)))) {
			String line = reader.readLine();
			while (line != null) {
				if (!line.isEmpty()) {
					line = reader.readLine();
					System.out.println(line);
					users.add(parseUserData(line));
				}
			}
		} catch (FileNotFoundException e) {
			// The file was not found
			e.printStackTrace();
		} catch (IOException e) {
			// The file was corrupt or it wasn't able to be read for some reason
			e.printStackTrace();
		}
		return users;
	}

	public static User parseUserData(String line) {
		if (line != null) {
			String[] values = line.split(",");
			int index = 0;
			int id = Integer.parseInt(values[index++]); // turn string into number
			String firstName = values[index++];
			String lastName = values[index++];
			String email = values[index++];

			return new User(id, firstName, lastName, email);
		}
		return null;
	}
	
	

}

class User {

	private int id;
	private String firstName;
	private String lastName;
	private String email;

	public User(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}

}
