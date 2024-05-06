package com.capstoneproject.mobilestore.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproject.mobilestore.Entity.Customer;
import com.capstoneproject.mobilestore.Repository.CustomerRepository;
import com.capstoneproject.mobilestore.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer getCustomerById(long customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		return optionalCustomer.get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}


	@Override
	public void deleteById(long customerId) {
		Optional<Customer> optionalcustomer = customerRepository.findById(customerId);
		if(optionalcustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not found with customer id "+customerId);
			
		}
		Customer customer =optionalcustomer.get();
		customerRepository.delete(customer);
		
	}
		


	@Override
	public Customer updateCustomer(Customer customer) {
		 Optional<Customer> optionalcustomer = customerRepository.findById(customer.getCustomerId());
	       if(optionalcustomer.isEmpty()) {
	    	   throw new ResourceNotFoundException("Customer not found with id "+customer.getCustomerId());
	       }
	       customerRepository.save(customer);
			return customer;
		}
	}




	
