package com.capstone.mobilestore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.mobilestore.entity.Cart;
import com.capstone.mobilestore.entity.CartItem;
import com.capstone.mobilestore.exception.ItemNotFoundException;
import com.capstone.mobilestore.model.CartItemResponse;
import com.capstone.mobilestore.model.Mobile;
import com.capstone.mobilestore.repository.CartItemRepository;
import com.capstone.mobilestore.repository.CartRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private MobileServiceConsumer mobileServiceConsumer;

	@Override
	public CartItem findByDifferentId	(Long cartId, Long mobileId, int quantity)  {
		Mobile mobile = mobileServiceConsumer.getMobileDetails(mobileId);

	    if (mobile==null) {
	        throw new ItemNotFoundException("Mobile not found with id: " + mobileId);
	    }
	    
	    Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ItemNotFoundException("Cart not found with id: " + cartId));


	    CartItem cartItem = cartItemRepository.findByCartIdAndMobileId(cartId, mobileId);
	    if (cartItem == null) {
	        cartItem = new CartItem();
	        cartItem.setId(cartId);
	        cartItem.setMobileId(mobileId);
	        cartItem.setCart(cart);
	    }

	    cartItem.setQuantity(quantity);

	    double itemTotal = calculateItemTotal(mobile.getPrice(), quantity);
	    cartItem.setItemTotal(itemTotal);

	    return cartItemRepository.save(cartItem);
	}

	private double calculateItemTotal(double price, int quantity) {
	    return price * quantity;
	}
	
	@Override
	public void removeItem(Long itemId) throws ItemNotFoundException {
		CartItem cartItem = getItemById(itemId);
		cartItemRepository.delete(cartItem);
		
	}

	@Override
	public CartItem updateQuantity(Long itemId, int quantity) throws ItemNotFoundException {
		CartItem cartItem = cartItemRepository.findById(itemId)
				.orElseThrow(() -> new ItemNotFoundException("CartItem not found with id: " + itemId));
		cartItem.setQuantity(quantity);
		return cartItemRepository.save(cartItem);
	}

	@Override
	public CartItem getItemById(Long itemId) throws ItemNotFoundException {
		return cartItemRepository.findById(itemId)
				.orElseThrow(() -> new ItemNotFoundException("CartItem not found with id: " + itemId));
	}

	@Override
	public CartItemResponse getMobileDetailsForCartItem(Long cartItemId) {
		 Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);
		    if (optionalCartItem.isEmpty()) {
		        throw new ItemNotFoundException("CartItem not found with Id : " + cartItemId);
		    }
		    CartItem cartItem = optionalCartItem.get();
		    
		    CartItemResponse cartItemResponse = new CartItemResponse();
		    cartItemResponse.setId(cartItem.getId());
		    cartItemResponse.setQuantity(cartItem.getQuantity());
		    cartItemResponse.setItemTotal(cartItem.getItemTotal());
		    cartItemResponse.setCart(cartItem.getCart());
		   
		   

		    Mobile mobile = mobileServiceConsumer.getMobileDetails(cartItem.getMobileId());
		    cartItemResponse.setMobile(mobile);
		   

		    return cartItemResponse;
	}

	@Override
	public List<CartItem> getAll() {
		List<CartItem> cartItem = cartItemRepository.findAll();
		return cartItem;
		
	}

	@Override
	public CartItem addCartItem(CartItem item) {
		cartItemRepository.save(item);
		return item;
	}

}
