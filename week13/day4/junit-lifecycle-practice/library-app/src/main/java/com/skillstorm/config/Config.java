package com.skillstorm.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Config {
	
	static Config getInstance() throws IOException, ClassNotFoundException {
		return null;
	}
	
	Connection getConnection() throws SQLException;

}
