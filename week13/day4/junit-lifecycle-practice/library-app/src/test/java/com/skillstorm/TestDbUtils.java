package com.skillstorm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.skillstorm.config.Config;

public class TestDbUtils implements Config {

	private String url;
	private String user;
	private String password;

	private static TestDbUtils instance;

	private TestDbUtils() throws IOException, ClassNotFoundException {
		readProperties();
	}

	private void readProperties() throws IOException, ClassNotFoundException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties props = new Properties();
		try (InputStream input = TestDbUtils.class.getClassLoader().getResourceAsStream("db.properties")) {
			props.load(input);
			this.url = props.getProperty("db.url");
			this.user = props.getProperty("db.user");
			this.password = props.getProperty("db.password");
			System.out.println(">> Reading properties: ");
			System.out.println("     url: " + url);
			System.out.println("     user: " + url);
			System.out.println("     password: " + url);
		}
	}

	public static TestDbUtils getInstance() throws IOException, ClassNotFoundException {
		if (instance == null)
			instance = new TestDbUtils();
		return instance;
	}

	public Connection getConnection() throws SQLException {
		System.out.println("Getting connection");
		return DriverManager.getConnection(url, user, password);
	}
}
