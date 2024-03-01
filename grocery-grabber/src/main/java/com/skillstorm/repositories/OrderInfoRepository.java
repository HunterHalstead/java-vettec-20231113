package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.models.OrderInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {

}
