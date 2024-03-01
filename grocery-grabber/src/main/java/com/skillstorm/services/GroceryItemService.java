package com.skillstorm.services;

import java.util.List;

import com.skillstorm.models.GroceryItem;

public interface GroceryItemService {
	
	List<GroceryItem> findAll();
	
	GroceryItem findById(long id);
	
	GroceryItem create(GroceryItem item, long orderId);

}
