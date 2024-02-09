package com.skillstorm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This is an overview of how to connect to a MySQL database using JDBC
 * Normally, we will use other tools to abstract away a lot of this work. Today
 * we'll work with the nitty gritty details.
 */
public class JdbcOverview {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner in = new Scanner(System.in);
		System.out.print("Login Username: ");
		String name = in.nextLine();
		in.close();
		// Step 1: Load the driver (optional in JDBC 4+)
		Class.forName("com.mysql.cj.jdbc.Driver"); // optional these days it happens automatically
		
		// Step 2: Get a connection
		String url = "jdbc:mysql://localhost:3306/bank"; // add the schema name and delete ?user=root
		String username = "root";
		String password = "rootroot"; // NEVER DO THIS this should be in properties file 
									  // and never pushed to a public github
		try (Connection conn = DriverManager.getConnection(url, username, password);) {
			// Step 3: Create a sql statement
			Statement stmt = conn.createStatement();
			
			// Step 4: Run the sql statement
			/*
			 * 3 choices for executing a sql statement
			 * 1. executeQuery(string) return ResultSet
			 *     - SELECT statemetns only
			 * 2. executeUpdate(string) returns int (number of rows effected)
			 *     - SET, INSERT, DELETE 
			 * 3. execute(string) returns boolean (true means there is a result set) .getResultSet()
			 *     - SELECT, SET, INSERT, DELETE
			 */
//			ResultSet rs = stmt.executeQuery("SELECT * FROM account"); // semicolon optional
//			System.out.println("Done");
			// Step 5: Process the results
			///////////////////////////////////////////////////////////////////////////////////
//			while (rs.next()) {
//				String customer = rs.getString("customer_name");
//				int id = rs.getInt("id");
//				double balance = rs.getDouble("balance");
//				System.out.printf("%d %20s $%.2f%n", id, customer, balance);
//			}
			/////////////////////////////////////////////////////////////////////////////////////
//			rs = stmt.executeQuery("SELECT * FROM account WHERE customer_name = \"" + name + "\";");
//			System.out.println("Here is your account info");
//			if (rs.next()) {
//				String customer = rs.getString("customer_name");
//				int id = rs.getInt("id");
//				double balance = rs.getDouble("balance");
//				System.out.printf("%d %20s $%.2f%n", id, customer, balance);
//			} else {
//				System.out.println("No account found");
//			}
			///////////////////////////////////////////////////////////////////////////////////////
			PreparedStatement prstmt= conn.prepareStatement("SELECT * FROM account WHERE customer_name = ?;");
			prstmt.setString(1, name); // not zero indexed
			System.out.println("Here is your account info:");
			ResultSet result = prstmt.executeQuery();
			if (result.next()) {
				String customer = result.getString("customer_name");
				int id = result.getInt("id");
				double balance = result.getDouble("balance");
				System.out.printf("%-5s %-20s %-10s%n", "Id", "Customer", "Balance");
				System.out.printf("%-5d %-20s $%-10.2f%n", id, customer, balance);
			} else {
				System.out.println("No account found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
