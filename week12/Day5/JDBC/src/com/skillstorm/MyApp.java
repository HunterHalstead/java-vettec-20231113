package com.skillstorm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.skillstorm.config.DbUtils;

public class MyApp {

	public static void main(String[] args) throws IOException {
		// Get user data

		Scanner in = new Scanner(System.in);
		System.out.print("Login Username: ");
		String name = in.nextLine();
		in.close();

		// Step 1 & 2: Load Driver and Get connection using DbUtils reading from
		// properties file
		DbUtils config = DbUtils.getInstance();
		try (Connection conn = config.getConnection()) {

			// Step 3: Create statement (use prepared statement NOT normal statement)
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE customer_name = ?");
			stmt.setString(1, name);

			// Step 4: Execute statement
			ResultSet rs = stmt.executeQuery();

			// Step 5: Process results
			if (rs.next()) {
				System.out.println("Account Details: ");

				String customer = rs.getString("customer_name");
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				System.out.printf("%d %20s $%.2f%n", id, customer, balance);
			} else {
				System.out.println("No account found for name \"" + name + "\"");
			}
		} catch (SQLException e) {
			System.out.println("Unable to get connection: " + e.getMessage());
		}
	}

}
