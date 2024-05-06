package com.capstone.mobilestore.model;

import java.util.List;
import java.util.Set;

import com.capstone.mobilestore.entity.CartItem;

import lombok.Data;



public class CartResponse {

	private long id;
	private  Customer customer;
	private Set<CartItem> cartItems;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Set<CartItem> set) {
		this.cartItems = set;
	}
	
	
}
