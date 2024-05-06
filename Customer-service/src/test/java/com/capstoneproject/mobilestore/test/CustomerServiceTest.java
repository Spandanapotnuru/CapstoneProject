package com.capstoneproject.mobilestore.test;

import com.capstoneproject.mobilestore.Entity.Customer;
import com.capstoneproject.mobilestore.Repository.CustomerRepository;
import com.capstoneproject.mobilestore.Service.CustomerServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerName("Doe");
        
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer savedCustomer = customerService.saveCustomer(customer);

        verify(customerRepository, times(1)).save(customer);
        assertNotNull(savedCustomer);
        assertEquals(customer.getCustomerId(), savedCustomer.getCustomerId());
        
    }

    @Test
    void testGetCustomerById() {
        long customerId = 1L;
        Customer customer = new Customer();
        customer.setCustomerId(customerId);

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        Customer result = customerService.getCustomerById(customerId);
        assertNotNull(result);
        assertEquals(customerId, result.getCustomerId());
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> expectedCustomers = new ArrayList<>();
        expectedCustomers.add(new Customer());
        expectedCustomers.add(new Customer());

        when(customerRepository.findAll()).thenReturn(expectedCustomers);

        List<Customer> result = customerService.getAllCustomers();
        assertEquals(expectedCustomers.size(), result.size());
    }
}

   
//    @Test
//    void testUpdateCustomer() {
//        Customer customer = new Customer();
//        customer.getCustomerId();
//       
//        customer.setCustomerName("Doe");
//        
//        when(customerRepository.save(customer)).thenReturn(customer);
//
//        Customer updatedCustomer = customerService.updateCustomer(customer);
//
//        verify(customerRepository, times(1)).save(customer);
//        assertNotNull(updatedCustomer);
//        assertEquals(customer.getCustomerId(), updatedCustomer.getCustomerId());
//    }
//    }

