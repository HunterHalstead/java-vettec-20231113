package com.skillstorm.services;

import java.util.List;

import com.skillstorm.models.GroceryItem;
import com.skillstorm.models.OrderInfo;
import com.skillstorm.repositories.GroceryItemRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {
	
	private GroceryItemRepository repo;
	
	private OrderInfoService service;
	
	public GroceryItemServiceImpl(GroceryItemRepository repo, OrderInfoService service) {
		this.repo = repo;
		this.service = service;
	}

	@Override
	public List<GroceryItem> findAll() {
		return repo.findAll();
	}

	@Override
	public GroceryItem findById(long id) {
		return repo.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public GroceryItem create(GroceryItem item, long orderId) {
		OrderInfo order = service.findById(orderId);
		if (order != null) {
			item.setOrder(order);
			return repo.save(item);
		} else {
			// ideally throw an exception to end transaction
			return null;
		}
	}

}
