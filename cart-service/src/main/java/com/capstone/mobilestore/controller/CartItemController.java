package com.capstone.mobilestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.mobilestore.entity.Cart;
import com.capstone.mobilestore.entity.CartItem;
import com.capstone.mobilestore.model.CartItemResponse;
import com.capstone.mobilestore.service.CartItemService;
import com.capstone.mobilestore.service.CartItemServiceImpl;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemServiceImpl;

	@PostMapping("/addOrUpdate")
    public ResponseEntity<CartItem> findByDifferentId(@RequestParam Long cartId,
                                                    @RequestParam Long mobileId,
                                                    @RequestParam int quantity) {
        CartItem cartItem = cartItemServiceImpl.findByDifferentId(cartId, mobileId, quantity);
        if (cartItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartItem);
    }



	    @PutMapping("/updateQuantity/{itemId}")
	    public ResponseEntity<CartItem> updateQuantity(@PathVariable Long itemId,
	                                                    @RequestParam int quantity) {
	        CartItem cartItem = cartItemServiceImpl.updateQuantity(itemId, quantity);
	        if (cartItem == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(cartItem, HttpStatus.OK);
	    }

	    @GetMapping("/{itemId}")
	    public ResponseEntity<CartItem> getItemById(@PathVariable Long itemId) {
	        CartItem cartItem = cartItemServiceImpl.getItemById(itemId);
	        if (cartItem == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(cartItem, HttpStatus.OK);
	    }
	    
	    @GetMapping("/{cartItemId}/mobile")
	    public ResponseEntity<CartItemResponse> getMobileDetailsForCartItem(@PathVariable("cartItemId") Long cartItemId) {
	        CartItemResponse cartItemResponse = cartItemServiceImpl.getMobileDetailsForCartItem(cartItemId);
	        return ResponseEntity.ok(cartItemResponse);
	    }
	    
	    @DeleteMapping("/{itemId}")
		public ResponseEntity<Void> removeItem(@PathVariable("itemId") Long itemId) {
			cartItemServiceImpl.removeItem(itemId);
			return ResponseEntity.ok().build();
		}
	    
	    @GetMapping("/all")
		public List<CartItem> getALL(){
		 List<CartItem> cartItem = cartItemServiceImpl.getAll();
		 return cartItem;
}
}
