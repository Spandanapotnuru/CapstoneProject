package com.capstone.mobilestore.test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.mobilestore.entity.Cart;
import com.capstone.mobilestore.model.CartResponse;
import com.capstone.mobilestore.model.Customer;
import com.capstone.mobilestore.repository.CartRepository;
import com.capstone.mobilestore.service.CartServiceImpl;

import static org.mockito.Mockito.*;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    @Test
    void testGetCartById() {
        Long cartId = 1L;
        Cart cart = new Cart();
        cart.setCartId(cartId);
       
        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));

        Cart result = cartService.getCartById(cartId);

        assertNotNull(result);
        assertEquals(cartId, result.getCartId());
        
    }

    @Test
    void testAddCart() {
        Cart cart = new Cart();
        cart.setCartId(1L);
        
        when(cartRepository.save(cart)).thenReturn(cart);

        Cart result = cartService.addCart(cart);

        verify(cartRepository, times(1)).save(cart);
        assertNotNull(result);
        assertEquals(cart.getCartId(), result.getCartId());
        
    }

//    @Test
//    void testGetCustomerDetailsForCart() {
//        Long cartId = 1L;
//        Cart cart = new Cart();
//        cart.setCartId(cartId);
//        
//
//        Customer customer = new Customer();
//        customer.setCustomerId(1L);
//        customer.setName("John Doe");
//       
//
//        
//
//        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));
//
//        CartResponse result = cartService.getCustomerDetailsForCart(cartId);
//
//        assertNotNull(result);
//        assertEquals(customer.getName(), result.getCustomer());
    

//    @Test
//    void testAddCartByCustomerId() {
//        Long customerId = 1L;
//        Cart cart = new Cart();
//        cart.setCartId(1L);
//       
//
//        when(cartRepository.save(any(Cart.class))).thenReturn(cart);
//
//        Cart result = cartService.addCartByCustomerId(customerId);
//
//        verify(cartRepository, times(1)).save(any(Cart.class));
//        assertNotNull(result);
//        assertEquals(customerId, result.getCustomerId());
//       
//    }

//    @Test
//    void testDeleteCart() {
//        Long cartId = 1L;
//
//        doNothing().when(cartRepository).deleteById(cartId);
//
//        cartService.deleteCart(cartId);
//
//        verify(cartRepository, times(1)).deleteById(cartId);
//    }

    @Test
    void testGetAll() {
        List<Cart> expectedCarts = List.of(new Cart(), new Cart());

        when(cartRepository.findAll()).thenReturn(expectedCarts);

        List<Cart> result = cartService.getAll();
        assertEquals(expectedCarts.size(), result.size());
    }
}
