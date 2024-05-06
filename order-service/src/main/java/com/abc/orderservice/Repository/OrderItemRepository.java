package com.abc.orderservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.orderservice.Entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{

}