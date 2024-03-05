package com.skillstorm.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Customer;
import com.skillstorm.services.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*") // I'm letting every domain call my api
public class CustomerController {

	private CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public List<Customer> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable long id) {
		return service.findById(id);
	}

	// Create customer - customer can exist without a order
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer save(@RequestBody Customer customer) {
		return service.create(customer);
	}
}