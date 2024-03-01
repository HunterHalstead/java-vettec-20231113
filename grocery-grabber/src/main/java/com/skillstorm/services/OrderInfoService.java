package com.skillstorm.services;

import java.util.List;

import com.skillstorm.models.OrderInfo;

public interface OrderInfoService {
	
	List<OrderInfo> findAll();

	OrderInfo findById(long id);

	OrderInfo create(OrderInfo order, long customerId);


}
