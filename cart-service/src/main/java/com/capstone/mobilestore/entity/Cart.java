package com.capstone.mobilestore.entity;


import java.util.List;
import java.util.Set;

import com.capstone.mobilestore.model.CartItemResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_tbl")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long cartId;

	@Column(name = "user_id")
	private Long customerId;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CartItem> cartItems;



	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId2) {
		this.customerId = customerId2;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	
}
