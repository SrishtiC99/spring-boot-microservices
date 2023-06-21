package com.srishti.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srishti.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
