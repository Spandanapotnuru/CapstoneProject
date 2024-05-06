package com.capstone.mobilestore.service;

import java.util.List;

import com.capstone.mobilestore.entity.Cart;
import com.capstone.mobilestore.model.CartResponse;

public interface CartService {

	Cart getCartById(Long cartId);
	
	Cart addCart(Cart cart);

   CartResponse getCustomerDetailsForCart(Long cartId);

    Cart addCartByCustomerId(Long customerId);
    
    void deleteCart(Long cartId);
    
    List<Cart> getAll();
}
