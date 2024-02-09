package com.skillstorm.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.skillstorm.config.DbUtils;
import com.skillstorm.models.Account;

public class AccountDaoMySQLImpl implements AccountDao {

	@Override
	public Optional<Account> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account save(Account e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account update(Account e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Account e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Account> findByName(String name) {
		// Step 1 & 2: Load Driver and Get connection using DbUtils reading from
		// properties file
		try {
			DbUtils config = DbUtils.getInstance();
			try (Connection conn = config.getConnection()) {

				// Step 3: Create statement (use prepared statement NOT normal statement)
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account WHERE customer_name = ?");
				stmt.setString(1, name);

				// Step 4: Execute statement
				ResultSet rs = stmt.executeQuery();

				// Step 5: Process results
				if (rs.next()) {
//						System.out.println("Account Details: ");

					String customer = rs.getString("customer_name");
					int id = rs.getInt("id");
					double balance = rs.getDouble("balance");
					
					// map your rows to objects
					Account account = new Account(id, name, balance);
					return Optional.of(account);
				} else {
					return Optional.empty(); // return null; don't use null as failure flag when using DAO pattern
				}
			} catch (SQLException e) {
				System.out.println("Unable to get connection: " + e.getMessage());
				return Optional.empty(); 
			}
		} catch (IOException e) {
			System.out.println("Unable to read from properties file");
			return Optional.empty(); 
		}
	}

}
