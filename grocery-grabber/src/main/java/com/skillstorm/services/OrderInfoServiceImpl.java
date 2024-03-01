package com.skillstorm.services;

import java.util.List;

import com.skillstorm.models.Customer;
import com.skillstorm.models.OrderInfo;
import com.skillstorm.repositories.OrderInfoRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
	
	private OrderInfoRepository repo;
	
	private CustomerService service;
	
	public OrderInfoServiceImpl(OrderInfoRepository repo, CustomerService service) {
		this.repo = repo;
		this.service = service;
	}

	@Override
	public List<OrderInfo> findAll() {
		return repo.findAll();
	}

	@Override
	public OrderInfo findById(long id) {
		return repo.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public OrderInfo create(OrderInfo order, long customerId) {
		// Get customer with given id
		Customer customer = service.findById(customerId);
		if (customer != null) {
			order.setCustomer(customer);
			return repo.save(order);
		} else {
//			throw new java.lang.RuntimeException("e");
			return null; // throw exception to cause transaction rollback
		}
	}

}
