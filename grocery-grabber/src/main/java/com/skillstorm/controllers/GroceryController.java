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

import com.skillstorm.models.GroceryItem;
import com.skillstorm.services.GroceryItemService;

@RestController
@RequestMapping("/items")
@CrossOrigin("*") // or localhost:4200 etc
public class GroceryController {

	private GroceryItemService service;

	public GroceryController(GroceryItemService service) {
		this.service = service;
	}

	@GetMapping
	public List<GroceryItem> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public GroceryItem findById(@PathVariable long id) {
		return service.findById(id);
	}
	
	// A Grocery Item cannot exist without an order
	@PostMapping("/{orderId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public GroceryItem save(@RequestBody GroceryItem customer, @PathVariable long orderId) {
		return service.create(customer, orderId);
	}
}
