package com.capstone.mobilestore.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.mobilestore.entity.Cart;
import com.capstone.mobilestore.exception.ItemNotFoundException;
import com.capstone.mobilestore.model.CartResponse;
import com.capstone.mobilestore.model.Customer;
import com.capstone.mobilestore.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;
   
    @Autowired
    private CustomerServiceConsumer customerServiceConsumer;

	@Override
	public Cart getCartById(Long cartId) {
		return cartRepository.findById(cartId)
                .orElseThrow(() -> new ItemNotFoundException("Cart not found with id: " + cartId));
	}

	@Override
	public CartResponse getCustomerDetailsForCart(Long cartId) {
		Optional<Cart> optionalCart = cartRepository.findById(cartId);
	    if (optionalCart.isEmpty()) {
	        throw new ItemNotFoundException("Cart not found with Id : " + cartId);
	    }
	    Cart cart = optionalCart.get();
	    
	    CartResponse cartResponse = new CartResponse();
	    cartResponse.setId(cart.getCartId());
	    cartResponse.setCartItems(cart.getCartItems());
	 
	    Customer customer = customerServiceConsumer.getCustomerById(cart.getCustomerId());
	    cartResponse.setCustomer(customer);
	    
	        return cartResponse;
	        
	        
	}

	@Override
	public Cart addCartByCustomerId(Long customerId) {
		Customer customer = customerServiceConsumer.getCustomerById(customerId);
        if (customer == null) {
            throw new ItemNotFoundException("Customer not found with id: " + customerId);
        }
        
        Cart newCart = new Cart();
        newCart.setCustomerId(customerId);
        return cartRepository.save(newCart);
	}

	@Override
	public void deleteCart(Long cartId) {
		Cart cart = getCartById(cartId); 
        cartRepository.delete(cart);
		
	}

	@Override
	public List<Cart> getAll() {
		List<Cart> cart = cartRepository.findAll();
		return cart;
	}

	@Override
	public Cart addCart(Cart cart) {
		cartRepository.save(cart);
		return cart;
	}



	
    
}