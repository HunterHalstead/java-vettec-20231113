package com.skillstorm.daos;

import java.util.List;
import java.util.Optional;

import com.skillstorm.models.Account;

/** 
 * This is an interface that defines all the interactions with the database
 */
public interface AccountDao {
	
	Optional<Account> findById(int id);
	
	Optional<Account> findByName(String name);
	
	List<Account> findAll();
	
	Account save(Account e);
	
	Account update(Account e);
	
	void delete(Account e);
	
	void deleteById(int id);
}