package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.models.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

}
