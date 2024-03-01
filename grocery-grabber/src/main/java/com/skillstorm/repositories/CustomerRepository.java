package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
