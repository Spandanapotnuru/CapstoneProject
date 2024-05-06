package com.capstoneproject.mobilestore.Service;


import java.util.List;
import java.util.Optional;

import com.capstoneproject.mobilestore.Entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	
	Customer getCustomerById(long customerId);
	
	List<Customer> getAllCustomers();

	void deleteById(long customerId);

	Customer updateCustomer(Customer customer);

	
}