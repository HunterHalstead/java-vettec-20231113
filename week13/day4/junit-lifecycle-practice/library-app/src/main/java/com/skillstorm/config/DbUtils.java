package com.skillstorm.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtils implements Config {

	private String url;
	private String user;
	private String password;

	private static DbUtils instance;

	private DbUtils() throws IOException, ClassNotFoundException {
		readProperties();
	}

	private void readProperties() throws IOException, ClassNotFoundException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties props = new Properties();
		try (InputStream input = DbUtils.class.getClassLoader().getResourceAsStream("db.properties")) {
			props.load(input);
			this.url = props.getProperty("db.url");
			this.user = props.getProperty("db.user");
			this.password = props.getProperty("db.password");
		}
	}

	public static DbUtils getInstance() throws IOException, ClassNotFoundException {
		if (instance == null)
			instance = new DbUtils();
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
