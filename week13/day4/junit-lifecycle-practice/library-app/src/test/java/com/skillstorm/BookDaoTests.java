package com.skillstorm;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skillstorm.config.Config;
import com.skillstorm.models.Book;

public class BookDaoTests {
	
	static Config config;

	@BeforeAll
	static void setupConfig() throws ClassNotFoundException, IOException, SQLException {
		// Create connection configuration
		config = TestDbUtils.getInstance();
		try (Connection conn = config.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO testlibrary.author (author_name, birth_year, nationality) VALUES "
					+ "('Jane Austen', 1775, 'English');");
			int numRowsEffected = stmt.executeUpdate();
			System.out.println("Inserted " + numRowsEffected + " into Author table");
			
			stmt = conn.prepareStatement("INSERT INTO testlibrary.genre (genre_name) VALUES\r\n"
					+ "    ('Fiction');");
			numRowsEffected = stmt.executeUpdate();
			System.out.println("Inserted " + numRowsEffected + " into Genre table");
			
		} catch (SQLException e) {
			System.out.println("Unable to get connection: " + e.getMessage());
		}
	}
	
//	@BeforeEach
//	void addData() {
//		try (Connection conn = config.getConnection()) {
//			int authorId = getId("author", "Jane Austen", conn);
//			int genreId = getId("genre", "Fiction", conn);
//			List<Book> books = new ArrayList<>();
//			books.add(new Book(0, "Pride and Prejudice", authorId, 1813, "9780141199078", genreId));
//			books.add(new Book(0, "Emma", authorId, 1815, "9781551113210", genreId));
//			String sql = "INSERT INTO testlibrary.book (title, author_id, publication_year, isbn, genre_id) VALUES "
//					+ "(?, ?, ?, ?, ?);";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			// Reuse the preparedStatement in the loop
//			int  counter = 0;
//			for (Book book : books) {
//				
//				stmt.setString(1, book.getTitle());
//				stmt.setInt(2, book.getAuthorId());
//				stmt.setInt(3, book.getPublicationYear());
//				stmt.setString(4, book.getISBN());
//				stmt.setInt(5, book.getGenreId());
//				// Execute statement
//				counter += stmt.executeUpdate();
//			}
//			System.out.println("Inserted " + counter + " rows in Book");
//			
//		} catch (SQLException e) {
//			System.out.println("Unable to get connection: " + e.getMessage());
//		}
//	}
//	
//	private int getId(String table, String value, Connection conn) throws SQLException {
//		String sql = "SELECT " + table + "_id FROM testlibrary." + table + " WHERE " + table + "_name = ?;";
//		PreparedStatement stmt = conn.prepareStatement(sql);
//		ResultSet rs = stmt.executeQuery();
//		if (rs.next())
//			return rs.getInt(1);
//		throw new SQLException("No " + "_id found for " + table + "_name of " + value);
//	}

	@Test
	void test1() {
		assertTrue(true);
	}
	
	void testFindAll() {
		
	}
	
	@AfterEach
	void truncateBookTable() {
		
	}

}
