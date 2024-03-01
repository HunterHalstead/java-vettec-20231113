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

import com.skillstorm.models.OrderInfo;
import com.skillstorm.services.OrderInfoService;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {
	
	private OrderInfoService service;
    
    public OrderController(OrderInfoService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<OrderInfo> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public OrderInfo findById(@PathVariable long id) {
        return service.findById(id);
    }
    
    // Order cannot exist without a customer
    @PostMapping("/{customerId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderInfo save(@RequestBody OrderInfo orderInfo, @PathVariable long customerId) {
        return service.create(orderInfo, customerId);
    }
    
}
