package com.capstone.mobilestore.service;

import java.util.List;

import com.capstone.mobilestore.entity.Cart;
import com.capstone.mobilestore.entity.CartItem;
import com.capstone.mobilestore.exception.ItemNotFoundException;
import com.capstone.mobilestore.model.CartItemResponse;

public interface CartItemService {
	
	CartItem findByDifferentId(Long cartId, Long mobileId, int quantity) throws ItemNotFoundException;
	
	CartItem addCartItem(CartItem item);

	void removeItem(Long itemId) throws ItemNotFoundException;
	
	CartItemResponse getMobileDetailsForCartItem(Long cartItemId);

	CartItem updateQuantity(Long itemId, int quantity) throws ItemNotFoundException;

	CartItem getItemById(Long itemId) throws ItemNotFoundException;
	
	List<CartItem> getAll();
}
