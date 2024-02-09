package com.skillstorm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

import com.skillstorm.config.DbUtils;
import com.skillstorm.daos.AccountDao;
import com.skillstorm.daos.AccountDaoMySQLImpl;
import com.skillstorm.models.Account;

public class MyApp {
	
	AccountDao dao = new AccountDaoMySQLImpl();

	public static void main(String[] args) throws IOException {
		MyApp app = new MyApp();
		app.start();
	}
	
	public void start() {

		Scanner in = new Scanner(System.in);
		System.out.print("Login Username: ");
		String name = in.nextLine();
		in.close();
		
		Optional<Account> result = dao.findByName(name);
		if (result.isPresent()) {
			Account account = result.get();
			System.out.println("Here is your Account info: ");
			System.out.println(account);
		} else {
			System.out.println("No account found");
		}
	}

}
