package com.skillstorm.services;

import java.util.List;

import com.skillstorm.models.Customer;
import com.skillstorm.repositories.CustomerRepository;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository repo;
	
	public CustomerServiceImpl(CustomerRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Customer> findAll() {
		return repo.findAll();
	}

	@Override
	public Customer findById(long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Customer create(Customer customer) {
		return repo.save(customer);
	}

}
