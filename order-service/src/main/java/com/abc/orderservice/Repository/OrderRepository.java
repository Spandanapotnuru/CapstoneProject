package com.abc.orderservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.orderservice.Entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}