package com.capstone.mobilestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.mobilestore.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

//	Cart findByUserId(Long customerId);

}
